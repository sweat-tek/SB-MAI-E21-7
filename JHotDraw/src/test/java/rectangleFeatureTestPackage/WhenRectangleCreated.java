/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleFeatureTestPackage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.geom.Point2D;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

/**
 *
 * @author peter
 */
public class WhenRectangleCreated extends Stage<WhenRectangleCreated>{
    
    @ExpectedScenarioState
    double x;
    
    @ExpectedScenarioState
    double y;
    
    @ExpectedScenarioState
    double width;
    
    @ExpectedScenarioState
    double height;
    
    @ExpectedScenarioState
    double rx;
    
    @ExpectedScenarioState
    double ry;
    
    @ProvidedScenarioState
    SVGRectFigure rectangle;
    
    @ProvidedScenarioState
    Point2D.Double point = new Point2D.Double(x,y);
    
    WhenRectangleCreated creatingARectangle(){
        rectangle = new SVGRectFigure(x, y, width, height, rx, ry);
        return this;
    }
}
