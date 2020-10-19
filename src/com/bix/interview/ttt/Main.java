package com.bix.interview.ttt;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.bix.interview.ttt.TicTacToeGame.DRAW;
import static com.bix.interview.ttt.TicTacToeGame.PLAY_O;
import static com.bix.interview.ttt.TicTacToeGame.PLAY_X;

public class Main {
    static String winner = null;

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe Game!");
        game.printChessBoard();

        System.out.println("By entering 1,2,3,4,...9 to place the stone. Player X will go first.");

        String currentPlayer = PLAY_X;
        while (winner == null) {
            System.out.println("Player " + currentPlayer + " please input a number:");
            int input;
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("please input 1 - 9");
                continue;
            }

            if (!game.placeStone(currentPlayer, input)) {
                continue;
            }
            currentPlayer = currentPlayer.equals(PLAY_X) ? PLAY_O : PLAY_X;
            winner = game.findWinner();
        }

        if (DRAW.equals(winner)) {
            System.out.println("The board is draw, Game Over!");
        } else {
            System.out.println("Player " + winner + " is win!");
        }
    }
}
