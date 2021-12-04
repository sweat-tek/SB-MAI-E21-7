/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;

/**
 *
 * @author danie
 */
public class GivenThereIsACanvas extends Stage<GivenThereIsACanvas>{
    
    @ProvidedScenarioState
    private DrawingEditor drawingEditor;

    public GivenThereIsACanvas thereIsACanvas() {
        drawingEditor = new DefaultDrawingEditor();
        DrawingView drawingView = new DefaultDrawingView();
        drawingView.setDrawing(new QuadTreeDrawing());
        drawingEditor.setActiveView(drawingView);
        return this;
    }
    
    
    
}
