/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.draw.*;

/**
 *
 * @author danie
 */
public class DrawStrategy {
    
    
    public void draw(Graphics2D g, SVGImageFigure figure){
        double opacity = OPACITY.get(figure);
        opacity = Math.min(Math.max(0d, opacity), 1d);
        if (opacity != 0d) {
            Composite savedComposite = g.getComposite();
            if (opacity != 1d) {
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
            }

            BufferedImage image = figure.getBufferedImage();
            if (image != null) {
                if (TRANSFORM.get(figure) != null) {
                    // FIXME - We should cache the transformed image.
                    //         Drawing a transformed image appears to be very slow.
                    Graphics2D gx = (Graphics2D) g.create();
                    
                    // Use same rendering hints like parent graphics
                    gx.setRenderingHints(g.getRenderingHints());
                    
                    gx.transform(TRANSFORM.get(figure));
                    gx.drawImage(image, (int) figure.getX(), (int) figure.getY(), (int) figure.getWidth(), (int) figure.getHeight(), null);
                    gx.dispose();
                } else {
                    g.drawImage(image, (int) figure.getX(), (int) figure.getY(), (int) figure.getWidth(), (int) figure.getHeight(), null);
                }
            } else {
                Shape shape = figure.getTransformedShape();
                g.setColor(Color.red);
                g.setStroke(new BasicStroke());
                g.draw(shape);
            }

            if (opacity != 1d) {
                g.setComposite(savedComposite);
            }
        }
    }
    
    
    
    
    
    
}
