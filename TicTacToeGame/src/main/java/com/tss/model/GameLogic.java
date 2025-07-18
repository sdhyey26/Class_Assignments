package com.tss.model;

public class GameLogic {
    private GameBoard board;

    public GameLogic(GameBoard board) {
        this.board = board;
    }

    public boolean isWin(char playerSymbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board.getCell(i, 0) == playerSymbol &&
                 board.getCell(i, 1) == playerSymbol &&
                 board.getCell(i, 2) == playerSymbol) ||

                (board.getCell(0, i) == playerSymbol &&
                 board.getCell(1, i) == playerSymbol &&
                 board.getCell(2, i) == playerSymbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((board.getCell(0, 0) == playerSymbol &&
             board.getCell(1, 1) == playerSymbol &&
             board.getCell(2, 2) == playerSymbol) ||

            (board.getCell(0, 2) == playerSymbol &&
             board.getCell(1, 1) == playerSymbol &&
             board.getCell(2, 0) == playerSymbol)) {
            return true;
        }

        return false;
    }

    public boolean isDraw() {
        // A draw means board is full and nobody has won
        return board.isFull() && !isWin('X') && !isWin('O');
    }
    
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board.getCell(row, col) == ' ';
    }

}
