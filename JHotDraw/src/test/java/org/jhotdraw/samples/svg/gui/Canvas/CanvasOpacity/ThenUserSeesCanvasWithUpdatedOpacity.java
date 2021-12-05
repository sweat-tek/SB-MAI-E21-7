package org.jhotdraw.samples.svg.gui.Canvas.CanvasOpacity;

import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DrawingEditor;
import static org.junit.Assert.*;

public class ThenUserSeesCanvasWithUpdatedOpacity {
    
    void aUserCanSeeHalfOpacity(DrawingEditor canvas) {
        
        Double resultopacity = canvas.getActiveView().getDrawing().getAttribute(AttributeKeys.CANVAS_FILL_OPACITY);
        Double expectedopacity = 0.5;
        
        assertEquals(expectedopacity, resultopacity);
    }
}
