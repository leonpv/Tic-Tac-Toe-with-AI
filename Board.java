package tictactoe;

import java.util.Random;

class Board {
    private final char player = 'X';
    private char[][] grid;
    private int intCoords1 = 0;
    private int intCoords2 = 0;

    public Board() {
        this.grid = new char[5][5];

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                this.grid[i][j] = '_';
            }
        }
    }

    public Board(String string) {
        this();

        this.grid[1][1] = string.charAt(0);
        this.grid[1][2] = string.charAt(1);
        this.grid[1][3] = string.charAt(2);

        this.grid[2][1] = string.charAt(3);
        this.grid[2][2] = string.charAt(4);
        this.grid[2][3] = string.charAt(5);

        this.grid[3][1] = string.charAt(6);
        this.grid[3][2] = string.charAt(7);
        this.grid[3][3] = string.charAt(8);
    }

    public void printGrid() {
        System.out.println("---------");
        for (int i = 1; i <= 3; i++) {
            System.out.print("| ");
            for (int j = 1; j <= 3; j++) {
                System.out.print(this.grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean stringTest(String coords1, String coords2) {
        try {
            intCoords1 = Integer.parseInt(coords1);
            intCoords2 = Integer.parseInt(coords2);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
    }

    public boolean numbersRangeTest() {
        if (!(intCoords1 >= 1 && intCoords1 <= 3)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (!(intCoords2 >= 1 && intCoords2 <= 3)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

    public boolean occupiedTest() {
        if (!(this.grid[intCoords1][intCoords2] == '_')) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public boolean gameStatus() {
        int xs = 0; // numbers of X in input
        int os = 0; // numbers of O in input
        boolean xWin = false;       // x Wins
        boolean oWin = false;       // o Wins
        boolean draw = false;       // Draw
        boolean impossible = false; // Impossible
        boolean notFinish = false; // Game not finished

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (this.grid[i][j] == 'X') {
                    xs += 1;
                } else if (this.grid[i][j] == 'O') {
                    os += 1;
                }
            }
        }
/*
        if (xs > os) {
            this.player = 'O';
        }
*/
        char ch0 = this.grid[1][1];
        char ch1 = this.grid[1][2];
        char ch2 = this.grid[1][3];
        char ch3 = this.grid[2][1];
        char ch4 = this.grid[2][2];
        char ch5 = this.grid[2][3];
        char ch6 = this.grid[3][1];
        char ch7 = this.grid[3][2];
        char ch8 = this.grid[3][3];

        int i0 = ch0 + ch1 + ch2;
        int i1 = ch3 + ch4 + ch5;
        int i2 = ch6 + ch7 + ch8;
        int i3 = ch0 + ch3 + ch6;
        int i4 = ch1 + ch4 + ch7;
        int i5 = ch2 + ch5 + ch8;
        int i6 = ch0 + ch4 + ch8;
        int i7 = ch2 + ch4 + ch6;

        //'X' + 'X' + 'X'   => 264
        //'O' + 'O' + 'O'   => 237

        if (i0 == 264 || i1 == 264 || i2 == 264 || i3 == 264 || i4 == 264 || i5 == 264 || i6 == 264 || i7 == 264) {
            xWin = true;
        }
        if (i0 == 237 || i1 == 237 || i2 == 237 || i3 == 237 || i4 == 237 || i5 == 237 || i6 == 237 || i7 == 237) {
            oWin = true;
        }

        draw = xs + os == 9;

        if (xWin == oWin || Math.abs(xs - os) > 1) {
            impossible = true;
        }
        if ((ch0 == 95 || ch1 == 95 || ch2 == 95 || ch3 == 95 || ch4 == 95 || ch5 == 95 ||
                ch6 == 95 || ch7 == 95 || ch8 == 95)) {
            notFinish = true;
        }

        if (xWin && !oWin && !impossible) {
            System.out.println("X wins");
            return false;
        }
        if (oWin && !xWin && !impossible) {
            System.out.println("O wins");
            return false;
        }
        if (draw && !notFinish) {
            System.out.println("Draw");
            return false;
        }
        if (Math.abs(xs - os) > 1) {
            System.out.println("Impossible");
            return false;
        }
        if (notFinish && !xWin && !oWin) {
            //System.out.println("Game not finished");
            return true;
        }
        System.out.println("Impossible");
        return false;
    }

    public void move(char ch) {
        this.grid[intCoords1][intCoords2] = ch;
    }

    public String Status() {
        int xs = 0; // numbers of X in input
        int os = 0; // numbers of O in input
        boolean xWin = false;       // x Wins
        boolean oWin = false;       // o Wins
        boolean draw = false;       // Draw
        boolean impossible = false; // Impossible
        boolean notFinish = false; // Game not finished

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (this.grid[i][j] == 'X') {
                    xs += 1;
                } else if (this.grid[i][j] == 'O') {
                    os += 1;
                }
            }
        }
        char ch0 = this.grid[1][1];
        char ch1 = this.grid[1][2];
        char ch2 = this.grid[1][3];
        char ch3 = this.grid[2][1];
        char ch4 = this.grid[2][2];
        char ch5 = this.grid[2][3];
        char ch6 = this.grid[3][1];
        char ch7 = this.grid[3][2];
        char ch8 = this.grid[3][3];

        int i0 = ch0 + ch1 + ch2;
        int i1 = ch3 + ch4 + ch5;
        int i2 = ch6 + ch7 + ch8;
        int i3 = ch0 + ch3 + ch6;
        int i4 = ch1 + ch4 + ch7;
        int i5 = ch2 + ch5 + ch8;
        int i6 = ch0 + ch4 + ch8;
        int i7 = ch2 + ch4 + ch6;

        //'X' + 'X' + 'X'   => 264
        //'O' + 'O' + 'O'   => 237

        if (i0 == 264 || i1 == 264 || i2 == 264 || i3 == 264 || i4 == 264 || i5 == 264 || i6 == 264 || i7 == 264) {
            xWin = true;
        }
        if (i0 == 237 || i1 == 237 || i2 == 237 || i3 == 237 || i4 == 237 || i5 == 237 || i6 == 237 || i7 == 237) {
            oWin = true;
        }

        draw = xs + os == 9;
        if (Math.abs(xs - os) > 1) {
            return "Impossible";
        }
        if ((ch0 == 95 || ch1 == 95 || ch2 == 95 || ch3 == 95 || ch4 == 95 || ch5 == 95 ||
                ch6 == 95 || ch7 == 95 || ch8 == 95)) {
            notFinish = true;
        }

        if (xWin && !oWin && !impossible) {
            return "X wins";
        }
        if (oWin && !xWin && !impossible) {
            return "O wins";
        }
        if (draw && !notFinish) {
            return "Draw";
        }
        if (Math.abs(xs - os) > 1) {
            return "Impossible";
        }
        if (notFinish && !xWin && !oWin) {
            return "Game not finished";
        }
        return "Impossible";
    }

    public void moveLevelEasy(char ch) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        while (true) {
            int a = random.nextInt(3) + 1;
            int b = random.nextInt(3) + 1;
            if (this.grid[a][b] == '_') {
                this.grid[a][b] = ch;
                break;
            }
        }
    }

    public void moveLevelMedium(char ch) {
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        while (true) {
            int a = random.nextInt(3) + 1;
            int b = random.nextInt(3) + 1;
            int sumX = 0;
            int sumO = 0;

            //row
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (grid[i][j] == 'X') {
                        sumX++;
                    }
                    if (grid[i][j] == 'O') {
                        sumO++;
                    }
                }
                if (sumO == 2 || sumX == 2) {
                    for (int j = 1; j <= 3; j++) {
                        if (this.grid[i][j] == '_') {
                            this.grid[i][j] = ch;
                            return;
                        }
                    }
                }
                sumX = 0;
                sumO = 0;
            }
            //cell
            for (int j = 1; j <= 3; j++) {
                for (int i = 1; i <= 3; i++) {
                    if (grid[i][j] == 'X') {
                        sumX++;
                    }
                    if (grid[i][j] == 'O') {
                        sumO++;
                    }
                }
                if (sumO == 2 || sumX == 2) {
                    for (int i = 1; i <= 3; i++) {
                        if (this.grid[i][j] == '_') {
                            this.grid[i][j] = ch;
                            return;
                        }
                    }
                }
                sumX = 0;
                sumO = 0;
            }
            //diagonal
            for (int i = 1; i <= 3; i++) {
                if (grid[i][i] == 'X') {
                    sumX++;
                }
                if (grid[i][i] == 'O') {
                    sumO++;
                }
            }
            if (sumO == 2 || sumX == 2) {
                for (int i = 1; i <= 3; i++) {
                    if (grid[i][i] == '_') {
                        this.grid[i][i] = ch;
                        return;
                    }
                }
            }
            sumX = 0;
            sumO = 0;
            for (int i = 1; i <= 3; i++) {
                if (grid[i][4 - i] == 'X') {
                    sumX++;
                }
                if (grid[i][4 - i] == 'O') {
                    sumO++;
                }
            }
            if (sumO == 2 || sumX == 2) {
                for (int i = 1; i <= 3; i++) {
                    if (grid[i][4 - i] == '_') {
                        this.grid[i][4 - i] = ch;
                        return;
                    }
                }
            }

            if (this.grid[a][b] == '_') {
                this.grid[a][b] = ch;
                break;
            }
        }
    }

}
