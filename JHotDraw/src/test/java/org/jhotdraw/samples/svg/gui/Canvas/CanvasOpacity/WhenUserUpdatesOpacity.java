package org.jhotdraw.samples.svg.gui.Canvas.CanvasOpacity;

import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DrawingEditor;

public class WhenUserUpdatesOpacity{
    
    DrawingEditor aUserUpdatesCanvasWithHalfOpacity(DrawingEditor canvas) {
        canvas.getActiveView().getDrawing().setAttribute(AttributeKeys.CANVAS_FILL_OPACITY, 0.5);
        return canvas;
    } 

}
