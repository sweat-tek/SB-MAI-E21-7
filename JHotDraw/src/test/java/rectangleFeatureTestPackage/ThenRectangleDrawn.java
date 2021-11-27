/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleFeatureTestPackage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.geom.Point2D;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

/**
 *
 * @author peter
 */
public class ThenRectangleDrawn extends Stage<ThenRectangleDrawn>{
    
    @ExpectedScenarioState
    SVGRectFigure rectangle;
    
    @ExpectedScenarioState
    Point2D.Double point;
    
    ThenRectangleDrawn rectangleExists(){
        rectangle.getBounds();
        rectangle.contains(point);
        return this;
    }
}
