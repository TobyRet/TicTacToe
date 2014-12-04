package com.codurance.ComputerStrategies;

import com.codurance.Board.Marker;
import com.codurance.Board.Nought;
import com.codurance.Board.Position;
import com.codurance.Board.Positions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComputerTurnGeneratorShould {

    private ComputerTurnGenerator computerTurnGenerator;
    private List<ComputerPlayerStrategy> computerStrategyList;
    @Mock Position mockedPosition;
    @Mock Positions positions;
    @Mock RandomStrategy randomStrategy;
    @Mock WinStrategy winStrategy;

    @Before
    public void initialise() {
        addStrategiesToList();
        computerTurnGenerator = new ComputerTurnGenerator(computerStrategyList);
    }

    @Test public void
    execute_strategies() {
        Marker noughtMarker = new Nought();
        computerTurnGenerator.calculateNextMove(noughtMarker,positions);
        verify(winStrategy).execute(noughtMarker, positions);
        verify(randomStrategy).execute(noughtMarker, positions);
    }

    private void addStrategiesToList() {
        computerStrategyList = new ArrayList();
        computerStrategyList.add(winStrategy);
        computerStrategyList.add(randomStrategy);
    }
}