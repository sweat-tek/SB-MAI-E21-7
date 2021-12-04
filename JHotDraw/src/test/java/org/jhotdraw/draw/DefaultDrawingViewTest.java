package org.jhotdraw.draw;

import org.assertj.core.api.Assertions;
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

    @Before
    public void setUp() {
        view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());
    }

    @After
    public void tearDown() {
        view = null;
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

        Assertions.assertThat(view.getDrawing().getChildCount()).isEqualTo(figuresList1.size() + figuresList2.size());

        view.addToSelection(figuresList1);

        view.delete();

        Assertions.assertThat(view.getDrawing().getChildren().containsAll(figuresList1)).isFalse();
        Assertions.assertThat(view.getDrawing().getChildren().containsAll(figuresList2)).isTrue();
        Assertions.assertThat(view.getDrawing().getChildCount()).isEqualTo(figuresList2.size());
    }

    @Test
    public void duplicate_SelectAll_ShouldDoubleFigureCount() {

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

        view.getDrawing().addAll(figuresList1);
        view.selectAll();
        view.duplicate();

        Assertions.assertThat(view.getDrawing().getChildCount()).isEqualTo(figuresList1.size()*2);
    }

}
