import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.tss.model.TicTacToeFacade;

public class TicTacToeFacadeTest {
    @Test
    public void testStartGame() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        char[][] board = facade.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board[i][j], "Board should be empty after startGame");
            }
        }
        assertEquals('X', facade.getCurrentPlayer(), "Current player should be X after startGame");
    }

    @Test
    public void testValidMove() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        String result = facade.makeMove(0, 0);
        assertEquals("Ongoing", result, "Valid move should return Ongoing");
        char[][] board = facade.getBoard();
        assertEquals('X', board[0][0], "Cell (0,0) should contain X");
        assertEquals('O', facade.getCurrentPlayer(), "Player should switch to O");
    }

    @Test
    public void testInvalidMoveOutOfBounds() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        String result = facade.makeMove(3, 0);
        assertEquals("Invalid position", result, "Out-of-bounds move should be invalid");
    }

    @Test
    public void testInvalidMoveOccupied() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        facade.makeMove(0, 0);
        String result = facade.makeMove(0, 0);
        assertEquals("Cell already occupied", result, "Occupied cell move should be invalid");
    }

    @Test
    public void testWinRow() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        facade.makeMove(0, 0);     
        facade.makeMove(1, 0); // O
        facade.makeMove(0, 1); // X
        facade.makeMove(1, 1); // O
        String result = facade.makeMove(0, 2); // X wins
        assertEquals("X wins", result, "X should win with row (0,0-2)");
    }

    @Test
    public void testWinColumn() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        facade.makeMove(0, 0); // X
        facade.makeMove(0, 1); // O
        facade.makeMove(1, 0); // X
        facade.makeMove(1, 1); // O
        String result = facade.makeMove(2, 0); // X wins
        assertEquals("X wins", result, "X should win with column (0-2,0)");
    }

    @Test
    public void testWinDiagonal() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        facade.makeMove(0, 0); // X
        facade.makeMove(0, 1); // O
        facade.makeMove(1, 1); // X
        facade.makeMove(0, 2); // O
        String result = facade.makeMove(2, 2); 
        assertEquals("X wins", result, "X should win with diagonal (0,0-2,2)");
    }

    @Test
    public void testDraw() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        facade.makeMove(0, 0); 
        facade.makeMove(0, 1); 
        facade.makeMove(0, 2); 
        facade.makeMove(1, 1); 
        facade.makeMove(1, 0); 
        facade.makeMove(2, 0); 
        facade.makeMove(1, 2); 
        facade.makeMove(2, 2); 
        String result = facade.makeMove(2, 1); 
        assertEquals("Draw", result, "Game should be a draw");
    }

    @Test
    public void testResetGame() {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
        facade.makeMove(0, 0); 
        facade.makeMove(0, 1); 
        char[][] boardBeforeReset = facade.getBoard();
        assertEquals('X', boardBeforeReset[0][0], "Cell (0,0) should contain X before reset");
        facade.startGame();
        char[][] boardAfterReset = facade.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', boardAfterReset[i][j], "Board should be empty after reset");
            }
        }
        assertEquals('X', facade.getCurrentPlayer(), "Current player should be X after reset");
    }
}
