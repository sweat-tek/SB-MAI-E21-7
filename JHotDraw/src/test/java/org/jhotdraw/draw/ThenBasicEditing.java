package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ThenBasicEditing extends Stage<ThenBasicEditing> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    @ExpectedScenarioState
    private Set<Figure> selectedFigures;

    @ExpectedScenarioState
    private Set<Figure> nonSelectedFigures;

    ThenBasicEditing onlyTheSelectedFiguresAreDeleted() {

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
        nonSelectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());

        Assertions.assertThat(editor.getActiveView().getDrawing().getChildCount()).isEqualTo(0);
        return this;
    }

    ThenBasicEditing onlyTheSelectedFiguresAreDuplicated() {

        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());
        nonSelectedFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());

        Assertions.assertThat(editor.getActiveView().getDrawing().getChildCount()).isEqualTo(2);
        return this;
    }

    ThenBasicEditing pastedFigureShouldBeTheOnlyFigureOnDrawing() {
        Assertions.assertThat(editor.getActiveView().getDrawing().getChildCount()).isEqualTo(1);
        return this;
    }

}
