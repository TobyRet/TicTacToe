package com.codurance.Board;

import com.codurance.Players.BoardMarker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LinesCheckerShould {

    @Test public void
    check_for_winner() {
        LinesChecker linesChecker = new LinesChecker(Lines.create());
        List<Move> boardWithWinningRow = new ArrayList<>();

        for(int i=0; i<3; i++) {
            Move crossMove = new Move();
            crossMove.setBoardMarkerValue(BoardMarker.CROSS);
            boardWithWinningRow.add(crossMove);
        }

        for(int i=0; i<6; i++) {
            boardWithWinningRow.add(new Move());
        }

        assertThat(linesChecker.checkForWin(boardWithWinningRow), is(true));
    }
}
