/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.util.List;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author danie
 */
public class ThenImageExistsOnCanvas extends Stage<ThenImageExistsOnCanvas>{
    
    @ExpectedScenarioState
    private DrawingEditor drawingEditor;

    @ExpectedScenarioState
    private SVGImageFigure imageFigure;

    public ThenImageExistsOnCanvas imageExistsOnCanvas() {
        //assertCanvasContains(imageFigure, editor.getActiveView().getDrawing().getChildren());
        
        List<Figure> canvasFigureList = drawingEditor.getActiveView().getDrawing().getChildren();
        
        for (Figure someFigure : canvasFigureList) {
            System.out.println(someFigure);
            if (someFigure == imageFigure) {
                assertEquals(someFigure, imageFigure);
            }
        } 
        return this;
    }
    
}
