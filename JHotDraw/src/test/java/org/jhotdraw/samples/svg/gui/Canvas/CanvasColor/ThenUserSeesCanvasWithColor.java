package org.jhotdraw.samples.svg.gui.Canvas.CanvasColor;

import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DrawingEditor;
import static org.junit.Assert.*;

public class ThenUserSeesCanvasWithColor{

    void aUserCanSeeTheColorBlack(DrawingEditor canvas) {
        
        Color resultcolor = canvas.getActiveView().getDrawing().getAttribute(AttributeKeys.CANVAS_FILL_COLOR);
        Color expectedcolor = Color.black;
        
        assertEquals(expectedcolor, resultcolor);
    }
}
