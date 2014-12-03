package com.codurance.Board;

//package com.codurance.Game;
//
//import com.codurance.Cell.Cell;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
public class LineShould {

    private List<Cell> cells;
    private Line line;

    @Test public void
    return_true_if_cells_have_same_values() {
        Line line = new Line(0,1,2);
        List<Cell> boardCells = rowWinNoughts();
        assertThat(line.cellsHaveSameValues(boardCells), is(true));
    }

//    @Test public void
//    return_false_if_cells_have_same_values() {
//        Line line = new Line(0,1,2);
//        List<Cell> boardCells = noWin();
//        assertThat(line.cellsHaveSameValues(boardCells), is(false));
//    }
//
//    @Test public void
//    know_return_correct_cell_if_there_a_computer_can_play_win_strategy() {
//        line = new Line(0,1,2);
//        List<Cell> boardCells = winScenario1();
//        assertThat(line.identifyWinScenarioCellPosition(boardCells).getValue(), is("2"));
//    }
//
//    private List<Cell> winScenario1() {
//        cells = new ArrayList();
//        for(int i=0; i<2; i++) {
//            Cell cell = new Cell();
//            cell.setValue("X");
//            cells.add(cell);
//        }
//
//        for(int i=0; i<6; i++) {
//            Cell cell = new Cell();
//            cells.add(cell);
//        }
//
//        return cells;
//    }
//
//    private List<Cell> rowWinNoughts() {
//        cells = new ArrayList();
//
//        for(int i=0; i<3; i++) {
//            Cell cell = new Cell();
//            cell.setValue("O");
//            cells.add(cell);
//        }
//        for(int i=3; i<9; i++) {
//            Cell cell = new Cell();
//            cells.add(cell);
//        }
//        return cells;
//    }
//
//    private List<Cell> noWin() {
//        cells = new ArrayList();
//
//        for(int i=0; i<9; i++) {
//            Cell cell = new Cell();
//            cells.add(cell);
//        }
//        return cells;
//    }
//}
