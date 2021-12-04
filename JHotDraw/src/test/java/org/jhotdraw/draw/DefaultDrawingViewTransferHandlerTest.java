package org.jhotdraw.draw;

import org.assertj.core.api.Assertions;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DefaultDrawingViewTransferHandlerTest {

    private DefaultDrawingViewTransferHandler transferHandler;
    private DrawingView view;
    private Drawing drawing;
    private Transferable t = mock(Transferable.class);

    @Before
    public void setUp() {
        transferHandler = new DefaultDrawingViewTransferHandler();
        view = new DefaultDrawingView();
        drawing = new DefaultDrawing();
        view.setDrawing(drawing);
    }

    @After
    public void tearDown() {
        transferHandler = null;
        view = null;
        drawing = null;
        t = null;
    }

    @Test
    public void importDataTest() throws IOException, UnsupportedFlavorException {

        List<InputFormat> list = new ArrayList<>();
        list.add(new TextInputFormat(new SVGTextFigure("myTextFigure")));
        drawing.setInputFormats(list);

        when(t.getTransferDataFlavors()).thenReturn(new DataFlavor[] {new DataFlavor(String.class, "myDataFlavor")});
        when(t.getTransferData(DataFlavor.stringFlavor)).thenReturn("My transfer data");

        boolean success = transferHandler.importData((JComponent) view, t);

        Assertions.assertThat(drawing.getChildCount()).isEqualTo(1);
        Assertions.assertThat(success).isTrue();
    }

}
