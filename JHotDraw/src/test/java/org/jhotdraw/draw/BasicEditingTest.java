package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class BasicEditingTest extends ScenarioTest<GivenBasicEditing, WhenBasicEditing, ThenBasicEditing> {

    @Test
    public void deletingSelectedFigures() {
        given().aSelectedFigure();
        when().deleteSelectedFigures();
        then().onlyTheSelectedFiguresAreDeleted();
    }

    @Test
    public void duplicateSelectedFigures() {
        given().aSelectedFigure();
        when().duplicateSelectedFigures();
        then().onlyTheSelectedFiguresAreDuplicated();
    }

    @Test
    public void pasteTransferableStringDataOntoEmptyDrawing() throws IOException, UnsupportedFlavorException {
        given().aTransferableWithStringFlavor();
        when().importDataFromTransferable();
        then().pastedFigureShouldBeTheOnlyFigureOnDrawing();
    }

}
