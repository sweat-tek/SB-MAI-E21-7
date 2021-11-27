/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleFeatureTestPackage;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author peter
 */
public class DrawingRectangleTest extends ScenarioTest<GivenParameters, WhenRectangleCreated, ThenRectangleDrawn>{
    
    @Test
    public void drawingRectangleTest(){
        given().anX().and().aY().and().aWidth().and().aHeight();
        when().creatingARectangle();
        then().rectangleExists();
    }
}
