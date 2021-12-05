package org.jhotdraw.samples.svg.gui.Canvas.CanvasColor;

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

public class GivenACanvas{
    
    @ProvidedScenarioState
    private DrawingEditor canvas;

    @BeforeStage
    private void before() {
        this.canvas = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());
        this.canvas.setActiveView(view);
    }
    
    DrawingEditor aCanvasWithWhiteColor(){
        Color expectedWhiteColor = Color.white;
        Color resultColor = this.canvas.getActiveView().getDrawing().getAttribute(AttributeKeys.CANVAS_FILL_COLOR);

        assertEquals(expectedWhiteColor, resultColor);
        
        return this.canvas; 
    }

}
