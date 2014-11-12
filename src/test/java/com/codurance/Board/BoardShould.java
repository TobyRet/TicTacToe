package com.codurance.Board;

//@RunWith(MockitoJUnitRunner.class)
//public class BoardShould {
//
//    private List<Cell> cells;
//    private Board board;
//    private final String BOARD_WITH_ONE_MOVE = "X--\n" + "---\n" + "---\n";
//
//    @Mock BoardFormatter boardFormatter;
//    @Mock Cell mockedCell;
//    @Mock
//    HumanPlayer mockedPlayer1;
//
//    @Before
//    public void
//    intialise_with_nine_cell_objects() {
//        board = new Board(createCells(), boardFormatter);
//    }
//
//    @Test public void
//    creates_an_empty_board_for_printing() {
//        String emptyBoard = "---\n" + "---\n" + "---\n";
//        given(boardFormatter.format(cells)).willReturn(emptyBoard);
//        assertThat(board.getBoardForPrinting(), is(emptyBoard));
//    }
//
//    @Test public void
//    add_a_players_move_to_the_board() {
//        board = new Board(createMockedCells(), boardFormatter);
//
//        given(mockedCell.getValue()).willReturn("-");
//        given(boardFormatter.format(cells)).willReturn(BOARD_WITH_ONE_MOVE);
//        given(mockedPlayer1.getMarker()).willReturn("X");
//
//        board.addMove(1, mockedPlayer1);
//
//        verify(mockedCell).setValue("X");
//
//        assertThat(board.getBoardForPrinting(), is(BOARD_WITH_ONE_MOVE));
//    }
//
//    @Test (expected=RuntimeException.class) public void
//    throw_exception_if_space_already_has_been_allocated() {
//        board = new Board(createMockedCells(), boardFormatter);
//
//        given(mockedCell.getValue()).willReturn("-");
//
//        board.addMove(1, mockedPlayer1);
//        given(mockedCell.getValue()).willReturn("X");
//
//        board.addMove(1, mockedPlayer1);
//    }
//
//    private List<Cell> createMockedCells() {
//        cells = new ArrayList();
//        for(int i=0; i<9; i++) {
//            cells.add(mockedCell);
//        }
//        return cells;
//    }
//
//    private List<Cell> createCells() {
//        cells = new ArrayList();
//        for(int i=0; i<9; i++) {
//            Cell cell = new Cell();
//            cells.add(cell);
//        }
//        return cells;
//    }
//}
