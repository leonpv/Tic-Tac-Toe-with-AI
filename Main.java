package tictactoe;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Board board = new Board();
            System.out.print("Input command: ");
            String[] inputArray = scanner.nextLine().trim().split("\\s+");
            if (inputArray[0].equals("exit")) {
                break;
            }
            if (inputArray.length != 3 || !inputArray[0].equals("start")) {
                System.out.println("Bad parameters!");
                continue;
            }
            board.printGrid();
            if (inputArray[1].equals("easy") && inputArray[2].equals("easy")) {
                while (board.gameStatus()) {
                    //II`s move X
                    board.moveLevelEasy('X');
                    board.printGrid();
                    if (gameEnd(board)) break;
                    //II`s move O
                    board.moveLevelEasy('O');
                    board.printGrid();
                }
            }
            if (inputArray[1].equals("user") && inputArray[2].equals("easy")) {
                while (board.gameStatus()) {
                    //input & other tests
                    inputTests(scanner, board);
                    //player`s move
                    board.move('X');
                    board.printGrid();
                    if (gameEnd(board)) break;
                    //II`s move
                    board.moveLevelEasy('O');
                    board.printGrid();
                }
            }
            if (inputArray[1].equals("easy") && inputArray[2].equals("user")) {
                while (board.gameStatus()) {
                    //II`s move
                    board.moveLevelEasy('X');
                    board.printGrid();
                    if (gameEnd(board)) break;
                    //input & other tests
                    inputTests(scanner, board);
                    //player`s move
                    board.move('O');
                    board.printGrid();
                }
            }
            if (inputArray[1].equals("user") && inputArray[2].equals("user")) {
                while (board.gameStatus()) {
                    //input & other tests
                    inputTests(scanner, board);
                    //player`s move
                    board.move('X');
                    board.printGrid();
                    if (gameEnd(board)) break;
                    //input & other tests
                    inputTests(scanner, board);
                    //player`s move
                    board.move('O');
                    board.printGrid();
                    if (gameEnd(board)) break;
                }
            }
            if (inputArray[1].equals("medium") && inputArray[2].equals("medium")) {
                while (board.gameStatus()) {
                    //II`s move X
                    board.moveLevelMedium('X');
                    board.printGrid();
                    if (gameEnd(board)) break;
                    //II`s move O
                    board.moveLevelMedium('O');
                    board.printGrid();
                }
            }
            if (inputArray[1].equals("user") && inputArray[2].equals("medium")) {
                while (board.gameStatus()) {
                    //input & other tests
                    inputTests(scanner, board);
                    //player`s move
                    board.move('X');
                    board.printGrid();
                    if (gameEnd(board)) break;
                    //II`s move
                    board.moveLevelMedium('O');
                    board.printGrid();
                }
            }
            if (inputArray[1].equals("medium") && inputArray[2].equals("user")) {
                while (board.gameStatus()) {
                    //II`s move
                    board.moveLevelMedium('X');
                    board.printGrid();
                    if (gameEnd(board)) break;
                    //input & other tests
                    inputTests(scanner, board);
                    //player`s move
                    board.move('O');
                    board.printGrid();
                }
            }

            BBoard bboard = new BBoard();
            BBoard.State X = BBoard.State.X;
            BBoard.State O = BBoard.State.O;

            if (inputArray[1].equals("hard") && inputArray[2].equals("user")) {
                while (!bboard.isGameOver()) {
                    //II`s move
                    System.out.println("Making move level \"hard\"");
                    MiniMax.run(O, bboard, 9);
                    System.out.println(bboard);
                    System.out.println();
                    try {
                        checkGame(bboard);
                        break;
                    } catch (IllegalStateException e) {
                        //do nothing
                    }
                    //input & other tests
                    int[] cords = inputTests(scanner, bboard);
                    //player`s move
                    bboard.move(cords[1] - 1, cords[0] - 1);
                    try {
                        checkGame(bboard);
                        break;
                    } catch (IllegalStateException e) {
                        //do nothing
                    }
                    System.out.println(bboard + "\n");
                }
            }
            if (inputArray[1].equals("user") && inputArray[2].equals("hard")) {
                while (!bboard.isGameOver()) {
                    //input & other tests
                    int[] cords = inputTests(scanner, bboard);
                    //player`s move
                    bboard.move(cords[1] - 1, cords[0] - 1);
                    try {
                        checkGame(bboard);
                        break;
                    } catch (IllegalStateException e) {
                        //do nothing
                    }
                    System.out.println(bboard);
                    System.out.println();
                    //II`s move
                    System.out.println("Making move level \"hard\"");
                    MiniMax.run(O, bboard, 9);
                    System.out.println(bboard);
                    System.out.println();
                    try {
                        checkGame(bboard);
                    } catch (IllegalStateException e) {
                        //do nothing
                    }
                }
            }
            if (inputArray[1].equals("hard") && inputArray[2].equals("hard")) {

                while (!bboard.isGameOver()) {
                    System.out.println("Making move level \"hard\"");
                    MiniMax.run(X, bboard, 9);
                    System.out.println(bboard.toString());
                    System.out.println();
                    try {
                        checkGame(bboard);
                        break;
                    } catch (IllegalStateException e) {
                        //do nothing
                    }
                    System.out.println("Making move level \"hard\"");
                    MiniMax.run(O, bboard, 9);
                    System.out.println(bboard.toString());
                    System.out.println();
                    try {
                        checkGame(bboard);
                    } catch (IllegalStateException e) {
                        //do nothing
                    }
                }
            }


        }
    }

    private static boolean checkGame(BBoard bboard) {
        if (bboard.getWinner() == BBoard.State.X) {
            System.out.println("X wins\n");
            return true;
        }
        if (bboard.getWinner() == BBoard.State.O) {
            System.out.println("O wins\n");
            return true;
        }
        if (bboard.getWinner() == BBoard.State.Blank) {
            System.out.println("Draw\n");
            return true;
        }
        return false;
    }

    private static void inputTests(Scanner scanner, Board board) {
        boolean stringTestPass = false;
        boolean numbersRangeTestPass = false;
        boolean occupiedTestPass = false;

        while (!stringTestPass || !numbersRangeTestPass || !occupiedTestPass) {
            System.out.print("Enter the coordinates: ");
            String[] inputArray2 = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray2)) continue;
            String coords1 = inputArray2[0];
            String coords2 = inputArray2[1];
            if (!(board.stringTest(coords1, coords2))) {
                continue;
            } else stringTestPass = true;
            if (!(board.numbersRangeTest())) {
                continue;
            } else numbersRangeTestPass = true;
            if (!(board.occupiedTest())) {
                //continue;
            } else occupiedTestPass = true;
        }
    }

    private static int[] inputTests(Scanner scanner, BBoard bboard) {
        boolean stringTestPass = false;
        boolean numbersRangeTestPass = false;
        boolean occupiedTestPass = false;
        int intCoords1 = -1;
        int intCoords2 = -1;
        while (!stringTestPass || !numbersRangeTestPass || !occupiedTestPass) {
            System.out.print("Enter the coordinates: ");
            String[] inputArray2 = scanner.nextLine().trim().split("\\s+");
            if (!isCheckInput(inputArray2)) continue;
            String coords1 = inputArray2[0];
            String coords2 = inputArray2[1];

            try {
                intCoords1 = Integer.parseInt(coords1);
                intCoords2 = Integer.parseInt(coords2);
                stringTestPass = true;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (!(intCoords1 >= 1 && intCoords1 <= 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (!(intCoords2 >= 1 && intCoords2 <= 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            numbersRangeTestPass = true;


            int fuckCoords = -1;
            if (intCoords1 == 1 && intCoords2 == 1) fuckCoords = 0;
            if (intCoords1 == 1 && intCoords2 == 2) fuckCoords = 1;
            if (intCoords1 == 1 && intCoords2 == 3) fuckCoords = 2;
            if (intCoords1 == 2 && intCoords2 == 1) fuckCoords = 3;
            if (intCoords1 == 2 && intCoords2 == 2) fuckCoords = 4;
            if (intCoords1 == 2 && intCoords2 == 3) fuckCoords = 5;
            if (intCoords1 == 3 && intCoords2 == 1) fuckCoords = 6;
            if (intCoords1 == 3 && intCoords2 == 2) fuckCoords = 7;
            if (intCoords1 == 3 && intCoords2 == 3) fuckCoords = 8;

            HashSet<Integer> availableMoves = bboard.getAvailableMoves();
            var itr = availableMoves.iterator();
            while (itr.hasNext()) {
                if (itr.next() == fuckCoords) {
                    occupiedTestPass = true;
                    break;
                }
            }
            if (!occupiedTestPass) {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
        return new int[]{intCoords1, intCoords2};
    }

    private static boolean gameEnd(Board board) {
        if (board.Status().equals("Impossible")) {
            System.out.println("Impossible");
            return true;
        }
        if (board.Status().equals("X wins")) {
            System.out.println("X wins");
            return true;
        }
        if (board.Status().equals("O wins")) {
            System.out.println("O wins");
            return true;
        }
        if (board.Status().equals("Draw")) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }


    private static boolean isCheckInput(String[] inputArray) {
        if (inputArray.length != 2) {
            System.out.println("You should enter numbers!");
            return false;
        }
        return true;
    }
}


/**
 * Abstract superclass for all AI players with different strategies.
 * To construct an AI player:
 * 1. Construct an instance (of its subclass) with the game Board
 * 2. Call setSeed() to set the computer's seed
 * 3. Call move() which returns the next move in an int[2] array of {row, col}.
 * <p>
 * The implementation subclasses need to override abstract method move().
 * They shall not modify Cell[][], i.e., no side effect expected.
 * Assume that next move is available, i.e., not game-over yet.
 * <p>
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 * <p>
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 * <p>
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 * <p>
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 * <p>
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 * <p>
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 */
/**
 * Uses the MiniMax algorithm to play a move in a game of Tic Tac Toe.
 */


