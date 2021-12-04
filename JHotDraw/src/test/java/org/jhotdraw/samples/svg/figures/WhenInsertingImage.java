/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.jhotdraw.draw.DrawingEditor;

/**
 *
 * @author danie
 */
public class WhenInsertingImage extends Stage<WhenInsertingImage> {
    
    @ProvidedScenarioState
    private DrawingEditor DrawingEditor;
    
    @ProvidedScenarioState
    private SVGImageFigure image;

    WhenInsertingImage insertingAnImage() throws IOException {
        URL url = WhenInsertingImage.class.getResource("/sadge.jpg");
        File image = new File(url.getPath());
        this.image = new SVGImageFigure(0,0,0,0);
        this.image.loadImage(image);
        
        DrawingEditor.getActiveView().getDrawing().add(this.image);
        
        
        return this;
    }
    
}
