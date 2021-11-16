package org.jhotdraw.draw;

import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.junit.*;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DefaultDrawingViewTest {

    private DefaultDrawingView view;

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

        view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());

    }

    @After
    public void tearDown() {

    }


    @Test
    public void delete_RemovesFigureCollection_SpecificFiguresNoLongerExistsOnDrawing() {

        Figure[] figures_1 = new Figure[] {
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true)
        };

        List<Figure> figuresList1 = Arrays.asList(figures_1);

        Figure[] figures_2 = new Figure[] {
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true),
                new SVGPathFigure(true)
        };

        List<Figure> figuresList2 = Arrays.asList(figures_2);

        view.getDrawing().addAll(figuresList1);
        view.getDrawing().addAll(figuresList2);

        view.addToSelection(figuresList1);

        view.delete();

        Assert.assertFalse(view.getDrawing().getChildren().containsAll(figuresList1));
        Assert.assertTrue(view.getDrawing().getChildren().containsAll(figuresList2));

    }

    @Test
    public void duplicate_SelectAll_ShouldDoubleFigureCount() {

        view.getDrawing().add(new SVGPathFigure(true));

        view.selectAll();

        view.duplicate();

        Assert.assertEquals(2, view.getDrawing().getChildren().size());

    }

}
