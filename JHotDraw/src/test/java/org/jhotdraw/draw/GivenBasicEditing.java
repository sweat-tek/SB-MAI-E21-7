package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.mockito.Mockito;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GivenBasicEditing extends Stage<GivenBasicEditing> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Transferable t = mock(Transferable.class);

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());
        editor.setActiveView(view);
    }

    GivenBasicEditing aSelectedFigure() {
        Figure f1 = new SVGPathFigure(true);
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);
        return this;
    }

    GivenBasicEditing aTransferableWithStringFlavor() throws IOException, UnsupportedFlavorException {
        List<InputFormat> list = new ArrayList<>();
        list.add(new TextInputFormat(new SVGTextFigure("myTextFigure")));
        editor.getActiveView().getDrawing().setInputFormats(list);

        Mockito.when(t.getTransferDataFlavors()).thenReturn(new DataFlavor[] {new DataFlavor(String.class, "myDataFlavor")});
        Mockito.when(t.getTransferData(DataFlavor.stringFlavor)).thenReturn("My transfer data");

        return this;
    }

}
