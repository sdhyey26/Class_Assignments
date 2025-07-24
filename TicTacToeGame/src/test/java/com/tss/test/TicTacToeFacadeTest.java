package com.tss.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeFacadeTest {

    private TicTacToeFacade game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToeFacade();
    }

    @Test
    public void testInitialPlayer() {
        assertEquals("X", game.getCurrentPlayer());
    }

    

    @Test
    public void testMakeInvalidMove() {
        game.makeMove(0, 0);
        assertFalse(game.makeMove(0, 0));
    }

    @Test
    public void testHorizontalWin() {
        game.makeMove(0, 0); 
        game.makeMove(1, 0); 
        game.makeMove(0, 1); 
        game.makeMove(1, 1); 
        game.makeMove(0, 2); 
        assertEquals("X wins!", game.checkGameStatus());
    }

    @Test
    public void testVerticalWin() {
        game.makeMove(0, 0); 
        game.makeMove(0, 1); 
        game.makeMove(1, 0); 
        game.makeMove(1, 1); 
        game.makeMove(2, 0); 
        assertEquals("X wins!", game.checkGameStatus());
    }

    @Test
    public void testDiagonalWin() {
        game.makeMove(0, 0); 
        game.makeMove(0, 1); 
        game.makeMove(1, 1); 
        game.makeMove(0, 2); 
        game.makeMove(2, 2); 
        assertEquals("X wins!", game.checkGameStatus());
    }

    @Test
    public void testDraw() {
        game.makeMove(0, 0); 
        game.makeMove(0, 1); 
        game.makeMove(0, 2); 
        game.makeMove(1, 1); 
        game.makeMove(1, 0); 
        game.makeMove(2, 0); 
        game.makeMove(1, 2); 
        game.makeMove(2, 2); 
        game.makeMove(2, 1); 
        assertEquals("Draw!", game.checkGameStatus());
    }

    @Test
    public void testResetGame() {
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.resetGame();
        assertEquals("X", game.getCurrentPlayer());
        assertTrue(game.makeMove(0, 0));
        assertTrue(game.getBoardDisplay().contains("X"));
    }

    @Test
    public void testInvalidPosition() {
        assertFalse(game.makeMove(-1, 0));
        assertFalse(game.makeMove(3, 0));
        assertFalse(game.makeMove(0, -1));
        assertFalse(game.makeMove(0, 3));
    }

}
