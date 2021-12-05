package org.jhotdraw.samples.svg.gui.Canvas.CanvasOpacity;

import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import static org.junit.Assert.assertEquals;
import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;

public class GivenACanvas {
    
    @ProvidedScenarioState
    private DrawingEditor canvas;

    @BeforeStage
    private void before() {
        this.canvas = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());
        this.canvas.setActiveView(view);
    }
    
    DrawingEditor aCanvasWithFullOpacity(){
        
        Double resultopacity = this.canvas.getActiveView().getDrawing().getAttribute(AttributeKeys.CANVAS_FILL_OPACITY);
        Double expectedopacity = 1.0;
        assertEquals(expectedopacity, resultopacity);
        
        return this.canvas; 
    }
}
