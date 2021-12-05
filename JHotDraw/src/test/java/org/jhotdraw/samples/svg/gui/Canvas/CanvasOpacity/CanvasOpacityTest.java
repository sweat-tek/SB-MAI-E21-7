package org.jhotdraw.samples.svg.gui.Canvas.CanvasOpacity;

import com.tngtech.jgiven.junit.ScenarioTest;

import org.jhotdraw.draw.DrawingEditor;
import org.junit.Test;

public class CanvasOpacityTest extends ScenarioTest<GivenACanvas, WhenUserUpdatesOpacity, ThenUserSeesCanvasWithUpdatedOpacity> {
    
    @Test
    public void canvasOpacityTest(){
        DrawingEditor canvas = given().aCanvasWithFullOpacity();
        canvas = when().aUserUpdatesCanvasWithHalfOpacity(canvas);
        then().aUserCanSeeHalfOpacity(canvas);
    }
}
