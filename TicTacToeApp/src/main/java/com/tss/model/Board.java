package com.tss.model;

	public class Board {
	    private char[][] grid;

	    public Board() {
	        grid = new char[3][3];
	        reset();
	    }

	    public boolean isCellEmpty(int row, int col) {
	        return grid[row][col] == ' ';
	    }

	    public void placeMark(int row, int col, char mark) {
	        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
	            grid[row][col] = mark;
	        }
	    }

	    public char getMark(int row, int col) {
	        return grid[row][col];
	    }

	    public boolean isFull() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (grid[i][j] == ' ') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public void reset() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                grid[i][j] = ' ';
	            }
	        }
	    }

	    public char[][] getGrid() {
	        return grid;
	    }
}
