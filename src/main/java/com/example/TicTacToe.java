package com.example;

import java.util.Scanner;

public class TicTacToe {

    private final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        this.board = new char[3][3];
        this.currentPlayer = 'x';
        initalizeBoard();
    }

    public void play() {
        boolean gameWon = false;
        int row;
        int col;

        Scanner scanner = new Scanner(System.in);
        while (!gameWon) {
            System.out.println("Board: ");
            printBoard();

            System.out.println("Player " + currentPlayer + ",  enter the row 1-3");
            row = scanner.nextInt() - 1;

            System.out.println("Player " + currentPlayer + " ebter the column(1-3): ");
            col = scanner.nextInt() - 1;

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                gameWon = checkWin(row, col);

                if (gameWon) {
                    System.out.println("Player " + currentPlayer + " wins!! 🎉✨😎 ");
                } else if (isFull()) {
                    System.out.println("Game ower!");
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Try again!");
            }
        }
    }

    private boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
                || (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
                || (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
                ;

    }

    private void initalizeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board[row][column] = ' ';
            }
        }
    }

    private void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
    }

    private boolean check() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("| " + board[row][col] + " ");

                System.out.println("|");
                if (board[row][col] == ' ') return false;
            }
        }
        return true;
    }


    private void switchPlayer() {
        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }

//    public static void main(String[] args) {
//        TicTacToe toe =new TicTacToe();
//        toe.printBoard();
//    }
}
