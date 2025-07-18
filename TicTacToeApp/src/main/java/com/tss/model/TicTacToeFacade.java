package com.tss.model;

public class TicTacToeFacade {
    private Board board;
    private char currentPlayer;

    public TicTacToeFacade() {
        board = new Board();
        currentPlayer = 'X';
    }

    public void startGame() {
        board.reset();
        currentPlayer = 'X';
    }

    public String makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return "Invalid position";
        }
        if (!board.isCellEmpty(row, col)) {
            return "Cell already occupied";
        }
        board.placeMark(row, col, currentPlayer);
        if (GameLogic.checkWinner(board, currentPlayer)) {
            return currentPlayer + " wins";
        } else if (GameLogic.isDraw(board)) {
            return "Draw";
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return "Ongoing";
        }
    }

    public char[][] getBoard() {
        return board.getGrid();
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
