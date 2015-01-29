//package com.codurance.Players;
//
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ComputerPlayerShould {
//
//    @Mock Position position;
//    @Mock Board board;
//    @Mock Console console;
//    @Mock ComputerTurnGenerator computerTurnGenerator;
//
//    @Ignore
//    @Test public void
//    add_move_to_the_board() {
//        ComputerPlayer computerPlayer = new ComputerPlayer(computerTurnGenerator, BoardMarker.NOUGHT);
//
//        computerPlayer.addMoveTo(board);
//
//        verify(console).computerMoveConfirmation();
//        verify(computerTurnGenerator).calculateNextMove(BoardMarker.NOUGHT, board);
//    }
//}
