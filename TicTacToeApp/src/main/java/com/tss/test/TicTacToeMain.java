package com.tss.test;

import java.util.Scanner;

import com.tss.model.TicTacToeFacade;

public class TicTacToeMain {
    public static void main(String[] args) {
        TicTacToeFacade game = new TicTacToeFacade();
        Scanner scanner = new Scanner(System.in);
        game.startGame();
        
        while (true) {
            printBoard(game.getBoard());
            System.out.println("Player " + game.getCurrentPlayer() + "'s turn");
            System.out.print("Enter row (0-2) and column (0-2): ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                String result = game.makeMove(row, col);
                System.out.println(result);
                if (result.equals("X wins") || result.equals("O wins") || result.equals("Draw")) {
                    printBoard(game.getBoard());
                    System.out.println("Game over: " + result);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numbers between 0 and 2.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }

    private static void printBoard(char[][] board) {

        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}
