package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.app.action.DeleteAction;

import javax.swing.*;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WhenBasicEditing extends Stage<WhenBasicEditing> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Transferable t;

    @ProvidedScenarioState
    private Set<Figure> selectedFigures;

    @ProvidedScenarioState
    private Set<Figure> nonSelectedFigures;

    private Action action;

    private DefaultDrawingViewTransferHandler transferHandler;

    private DrawingView view;

    @BeforeStage
    public void before() {
        view = editor.getActiveView();
        transferHandler = new DefaultDrawingViewTransferHandler();
    }

    WhenBasicEditing deleteSelectedFigures() {

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
        nonSelectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());

        action = new DeleteAction();
        action.actionPerformed(null);

        DefaultDrawingView defaultView = (DefaultDrawingView) view;

        defaultView.delete();

        return this;
    }

    WhenBasicEditing duplicateSelectedFigures() {

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
        nonSelectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());

        DefaultDrawingView defaultView = (DefaultDrawingView) view;

        defaultView.duplicate();

        return this;
    }

    WhenBasicEditing importDataFromTransferable() throws IOException, UnsupportedFlavorException {
        transferHandler.importData((JComponent) view, t);
        return this;
    }

}
