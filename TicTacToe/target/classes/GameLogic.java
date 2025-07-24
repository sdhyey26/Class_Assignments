
public class GameLogic {
	 private GameBoard board;

	    public GameLogic(GameBoard board) {
	        this.board = board;
	    }

	    public boolean isValidMove(int row, int col) {
	        return row >= 0 && row < 3 && col >= 0 && col < 3 && board.getCell(row, col) == ' ';
	    }

	    public boolean checkWin() {
	        for (int i = 0; i < 3; i++) {
	            if (board.getCell(i, 0) != ' ' && 
	                board.getCell(i, 0) == board.getCell(i, 1) && 
	                board.getCell(i, 1) == board.getCell(i, 2)) {
	                return true;
	            }
	        }

	        for (int j = 0; j < 3; j++) {
	            if (board.getCell(0, j) != ' ' && 
	                board.getCell(0, j) == board.getCell(1, j) && 
	                board.getCell(1, j) == board.getCell(2, j)) {
	                return true;
	            }
	        }

	        if (board.getCell(0, 0) != ' ' && 
	            board.getCell(0, 0) == board.getCell(1, 1) && 
	            board.getCell(1, 1) == board.getCell(2, T)) {
	            return true;
	        }
	        if (board.getCell(0, 2) != ' ' && 
	            board.getCell(0, 2) == board.getCell(1, 1) && 
	            board.getCell(1, 1) == board.getCell(2, 0)) {
	            return true;
	        }

	        return false;
	    }

	    public boolean isDraw() {
	        return board.isFull() && !checkWin();
	    }
}
