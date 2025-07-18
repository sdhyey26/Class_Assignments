package com.tss.model;

public class GameLogic {
    public static boolean checkWinner(Board board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board.getMark(i, 0) == player && board.getMark(i, 1) == player && board.getMark(i, 2) == player) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board.getMark(0, j) == player && board.getMark(1, j) == player && board.getMark(2, j) == player) {
                return true;
            }
        }
        if (board.getMark(0, 0) == player && board.getMark(1, 1) == player && board.getMark(2, 2) == player) {
            return true;
        }
        if (board.getMark(0, 2) == player && board.getMark(1, 1) == player && board.getMark(2, 0) == player) {
            return true;
        }
        return false;
    }

    public static boolean isDraw(Board board) {
        return board.isFull() && !checkWinner(board, 'X') && !checkWinner(board, 'O');
    }
}
