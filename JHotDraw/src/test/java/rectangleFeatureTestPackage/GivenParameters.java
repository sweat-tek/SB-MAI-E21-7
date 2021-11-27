/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleFeatureTestPackage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

/**
 *
 * @author peter
 */
public class GivenParameters extends Stage<GivenParameters>{
    
    @ProvidedScenarioState
    double x;
    
    @ProvidedScenarioState
    double y;
    
    @ProvidedScenarioState
    double width;
    
    @ProvidedScenarioState
    double height;
    
    @ProvidedScenarioState
    double rx;
    
    @ProvidedScenarioState
    double ry;
    
    GivenParameters anX(){
        x = 4;
        return this;
    }
    
    GivenParameters aY(){
        y = 6;
        return this;
    }
    
    GivenParameters aWidth(){
        width = 20;
        return this;
    }
    
    GivenParameters aHeight(){
        height = 10;
        return this;
    }
}
