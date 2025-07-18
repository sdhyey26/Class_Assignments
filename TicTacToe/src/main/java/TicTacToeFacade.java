import com.tss
public class TicTacToeFacade {
	 private GameBoard board;
	    private GameLogic logic;
	    private PlayerManager playerManager;

	    public TicTacToeFacade() {
	        this.board = new GameBoard();
	        this.logic = new GameLogic(board);
	        this.playerManager = new PlayerManager();
	    }

	    public boolean makeMove(int row, int col) {
	        if (logic.isValidMove(row, col)) {
	            board.placeMark(row, col, playerManager.getCurrentPlayer());
	            return true;
	        }
	        return false;
	    }

	    public String getCurrentPlayer() {
	        return playerManager.getCurrentPlayer();
	    }

	    public String checkGameStatus() {
	        if (logic.checkWin()) {
	            return playerManager.getCurrentPlayer() + " wins!";
	        }
	        if (logic.isDraw()) {
	            return "Draw!";
	        }
	        playerManager.switchPlayer();
	        return "Continue";
	    }

	    public void resetGame() {
	        board.resetBoard();
	        playerManager.reset();
	    }

	    public String getBoardDisplay() {
	        return board.getDisplay();
	    }
}
