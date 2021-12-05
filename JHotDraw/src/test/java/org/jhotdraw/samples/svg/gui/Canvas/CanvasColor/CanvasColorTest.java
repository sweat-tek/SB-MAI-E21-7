package org.jhotdraw.samples.svg.gui.Canvas.CanvasColor;


import com.tngtech.jgiven.junit.ScenarioTest;

import org.jhotdraw.draw.DrawingEditor;
import org.junit.Test;

public class CanvasColorTest extends ScenarioTest<GivenACanvas, WhenUserUpdatesColor, ThenUserSeesCanvasWithColor> {
    

    @Test
    public void canvasColorTest(){
        DrawingEditor canvas = given().aCanvasWithWhiteColor();
        canvas = when().aUserUpdatesCanvasWithBlackColor(canvas);
        then().aUserCanSeeTheColorBlack(canvas);
    }
}
