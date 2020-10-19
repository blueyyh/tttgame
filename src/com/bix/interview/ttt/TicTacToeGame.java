package com.bix.interview.ttt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TicTacToeGame {

    public static final String PLAY_X = "X";
    public static final String PLAY_O = "O";
    public static final String DRAW = "Draw";

    private static final String PLAY_X_WIN = "XXX";
    private static final String PLAY_O_WIN = "OOO";

    private final String[] chessBoard = new String[9];

    private final List<int[]> winRow = Arrays.asList(
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 9},
            new int[]{1, 4, 7},
            new int[]{2, 5, 8},
            new int[]{3, 6, 9},
            new int[]{1, 5, 9},
            new int[]{3, 5, 7});

    public TicTacToeGame() {
        refreshChessBoard();
    }

    public boolean placeStone(String player, int input) {

        if (input <= 0 || input > 9) {
            System.out.println("Invalid input! the input must be between 1 - 9. ");
            return false;
        }

        if (chessBoard[input - 1].equals(String.valueOf(input))) {
            chessBoard[input - 1] = player;
            printChessBoard();
        } else {
            System.out.println("You cannot place here, the intersection is not vacant. ");
            return false;
        }

        return true;
    }

    public String findWinner() {

        return winRow.stream()
                .filter(this::playerWin)
                .findAny()
                .map(row -> chessBoard[row[0] - 1])
                .orElseGet(() -> isDraw() ? DRAW : null);

    }

    public void printChessBoard() {
        System.out.println("|-----------|");
        System.out.println("|-" + chessBoard[0] + "- " + "-" + chessBoard[1] + "- " + "-" + chessBoard[2] + "-|");
        System.out.println("|-" + chessBoard[3] + "- " + "-" + chessBoard[4] + "- " + "-" + chessBoard[5] + "-|");
        System.out.println("|-" + chessBoard[6] + "- " + "-" + chessBoard[7] + "- " + "-" + chessBoard[8] + "-|");
        System.out.println("|-----------|");
    }

    private boolean isDraw() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).noneMatch(i -> chessBoard[i - 1].equals(String.valueOf(i)));
    }

    private boolean playerWin(int[] row) {
        String line = winLine(row);
        return line.equals(PLAY_X_WIN) || line.equals(PLAY_O_WIN);
    }

    private String winLine(int[] row) {
        return chessBoard[row[0] - 1] + chessBoard[row[1] - 1] + chessBoard[row[2] - 1];
    }

    private void refreshChessBoard() {
        for (int i = 0; i < 9; i++) {
            chessBoard[i] = i + 1 + "";
        }
    }
}
