package com.tss.model;

public class GameBoard {
	private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean placeMark(int row, int col, String player) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = player.charAt(0);
            return true;
        }
        return false;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public String getDisplay() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("|");
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]).append("|");
            }
            sb.append("\n");
            if (i < 2) {
                sb.append("-----\n");
            }
        }
        return sb.toString();
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
