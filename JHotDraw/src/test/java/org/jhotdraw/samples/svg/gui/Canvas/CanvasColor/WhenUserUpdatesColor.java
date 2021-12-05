package org.jhotdraw.samples.svg.gui.Canvas.CanvasColor;

import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DrawingEditor;

public class WhenUserUpdatesColor{
    
    DrawingEditor aUserUpdatesCanvasWithBlackColor(DrawingEditor canvas) {
        canvas.getActiveView().getDrawing().setAttribute(AttributeKeys.CANVAS_FILL_COLOR, Color.black);
        return canvas;
    }   
}
