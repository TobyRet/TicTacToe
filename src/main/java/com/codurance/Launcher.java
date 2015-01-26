package com.codurance;

//import com.codurance.ComputerStrategies.RandomStrategy;
//import com.codurance.ComputerStrategies.WinStrategy;

public class Launcher {

//    private static Console console;
//    private static Game game;
//    private static Scanner scanner;
//    private static Formatter formatter;
//    private static Board board;
//    private static Lines lines;
//    private static List<Player> players;
//    private static HumanPlayer humanPlayer1;
//    private static HumanPlayer humanPlayer2;
//    private static ComputerPlayer computerPlayer;
////    private static RandomStrategy randomStrategy;
//    private static List<ComputerPlayerStrategy> computerStrategyList;
//    private static List<Line> linesList;
////    private static WinStrategy winStrategy;
//    private static ComputerTurnGenerator computerTurnGenerator;
//    private static Random randomGenerator;
//
//    public static void main(String[] args) {
//        createGameComponents();
//        game.start();
//    }
//
//    private static void createGameComponents() {
//        createPlayers();
//        scanner = new Scanner(System.in);
//        console = new Console();
//        formatter = new Formatter();
//        lines = new Lines(linesList);
////        board = new Board();
////        game = new Game(console, board, players);
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
//        createComputerStrategyList();
//
//        computerTurnGenerator = new ComputerTurnGenerator(computerStrategyList);
//        computerPlayer = new ComputerPlayer(computerTurnGenerator, BoardMarker.CROSS);
//    }
//
//    private static List<ComputerPlayerStrategy> createComputerStrategyList() {
//        computerStrategyList = new ArrayList<>();
//        randomGenerator = new Random();
//        lines = new Lines(createLines());
////        winStrategy = new WinStrategy(lines);
////        randomStrategy = new RandomStrategy(randomGenerator);
//
////        computerStrategyList.add(winStrategy);
////        computerStrategyList.add(randomStrategy);
//
//        return computerStrategyList;
//    }
//
//    private static void createHumanPlayer2() {
//        humanPlayer2 = new HumanPlayer(BoardMarker.NOUGHT, console);
//    }
//
//    private static void createHumanPLayer1() {
//        humanPlayer1 = new HumanPlayer(BoardMarker.CROSS, console);
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
}
