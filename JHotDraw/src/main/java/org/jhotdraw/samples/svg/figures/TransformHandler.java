/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import static org.jhotdraw.draw.AttributeKeys.TRANSFORM;
import org.jhotdraw.samples.svg.Gradient;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_GRADIENT;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.STROKE_GRADIENT;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.*;
import org.jhotdraw.geom.*;

/**
 *
 * @author peter
 */
public class TransformHandler {
    
    public void handleTransform(AffineTransform tx, Figure f) {
        if (TRANSFORM.get(f) != null
                || (tx.getType() & (AffineTransform.TYPE_TRANSLATION)) != tx.getType()) {
            if (TRANSFORM.get(f) == null) {
                TRANSFORM.basicSet(f, (AffineTransform) tx.clone());
            } else {
                AffineTransform t = TRANSFORM.getClone(f);
                t.preConcatenate(tx);
                TRANSFORM.basicSet(f, t);
            }
        } else {
            Point2D.Double anchor = f.getStartPoint();
            Point2D.Double lead = f.getEndPoint();
            f.setBounds(
                    (Point2D.Double) tx.transform(anchor, anchor),
                    (Point2D.Double) tx.transform(lead, lead));
            if (FILL_GRADIENT.get(f) != null
                    && !FILL_GRADIENT.get(f).isRelativeToFigureBounds()) {
                Gradient g = FILL_GRADIENT.getClone(f);
                g.transform(tx);
                FILL_GRADIENT.basicSet(f, g);
            }
            if (STROKE_GRADIENT.get(f) != null
                    && !STROKE_GRADIENT.get(f).isRelativeToFigureBounds()) {
                Gradient g = STROKE_GRADIENT.getClone(f);
                g.transform(tx);
                STROKE_GRADIENT.basicSet(f, g);
            }
        }

    }
}
