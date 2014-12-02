//package com.codurance;
//
//public class Launcher {
//
//    private static Console console;
//    private static Game game;
//    private static Scanner scanner;
//    private static TicTacToe ticTacToe;
//    private static BoardFormatter boardFormatter;
//    private static Board board;
//    private static Lines lines;
//    private static List<Cell> cells;
//    private static List<Player> players;
//    private static PlayerName playerNameHuman1;
//    private static BoardMarker boardMarkerHuman1;
//    private static HumanPlayer humanPlayer1;
//    private static PlayerName playerNameHuman2;
//    private static BoardMarker boardMarkerHuman2;
//    private static HumanPlayer humanPlayer2;
//    private static BoardMarker boardMarkerComputer;
//    private static ComputerPlayer computerPlayer;
//    private static ComputerMove computerMoves;
//    private static RandomStrategy randomStrategy;
//    private static List<ComputerPlayerStrategy> computerStrategyList;
//    private static List<Line> linesList;
//    private static WinStrategy winStrategy;
//
//    public static void main(String[] args) {
//        createGameComponents();
//        ticTacToe.loadGameType();
//    }
//
//    private static void createGameComponents() {
//        createCells();
//        scanner = new Scanner(System.in);
//        console = new Console(scanner);
//        boardFormatter = new BoardFormatter();
//        board = new Board(cells, boardFormatter);
//        lines = new Lines(board.getCells(), createLines());
//        createPlayers();
//        game = new Game(players, board, console, lines);
//        ticTacToe = new TicTacToe(console, game);
//    }
//
//    private static void createPlayers() {
//        players = new ArrayList();
//
//        createHumanPLayer1();
//        createHumanPlayer2();
//        createComputerPlayer();
//
//        players.add(humanPlayer1);
//        players.add(humanPlayer2);
//        players.add(computerPlayer);
//    }
//
//    private static void createComputerPlayer() {
//        boardMarkerComputer = new BoardMarker("X");
//        randomStrategy = new RandomStrategy();
//        createComputerStrategyList();
//        computerMoves = new ComputerMove(computerStrategyList, board);
//        computerPlayer = new ComputerPlayer(computerMoves, boardMarkerComputer);
//    }
//
//    private static List<ComputerPlayerStrategy> createComputerStrategyList() {
//        computerStrategyList = new ArrayList<>();
//
//        randomStrategy = new RandomStrategy();
//        winStrategy = new WinStrategy(lines);
//
//        computerStrategyList.add(winStrategy);
//        computerStrategyList.add(randomStrategy);
//
//        return computerStrategyList;
//    }
//
//    private static void createHumanPlayer2() {
//        playerNameHuman2 = new PlayerName("Player 2");
//        boardMarkerHuman2 = new BoardMarker("X");
//        humanPlayer2 = new HumanPlayer(playerNameHuman2, boardMarkerHuman2);
//    }
//
//    private static void createHumanPLayer1() {
//        playerNameHuman1 = new PlayerName("Player 1");
//        boardMarkerHuman1 = new BoardMarker("O");
//        humanPlayer1 = new HumanPlayer(playerNameHuman1, boardMarkerHuman1);
//    }
//
//    private static List<Line> createLines() {
//
//        linesList = new ArrayList();
//
//        Line row1 = new Line(0,1,2);
//        Line row2 = new Line(3,4,5);
//        Line row3 = new Line(6,7,8);
//        Line column1 = new Line(0,3,6);
//        Line column2 = new Line(1,4,7);
//        Line column3 = new Line(2,5,8);
//        Line diagonal1 = new Line(0,4,8);
//        Line diagonal2 = new Line(2,4,6);
//
//        linesList.add(row1);
//        linesList.add(row2);
//        linesList.add(row3);
//        linesList.add(column1);
//        linesList.add(column2);
//        linesList.add(column3);
//        linesList.add(diagonal1);
//        linesList.add(diagonal2);
//
//        return linesList;
//    }
//
//    private static void createCells() {
//        cells = new ArrayList();
//        for(int i=0; i<9; i++) {
//            Cell cell = new Cell();
//            cells.add(cell);
//        }
//    }
//}
