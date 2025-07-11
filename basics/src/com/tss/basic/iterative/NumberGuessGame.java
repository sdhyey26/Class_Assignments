package com.tss.basic.iterative;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String playAgain = "yes";

		while (playAgain.equalsIgnoreCase("yes")) {
			int number = random.nextInt(100) + 1;
			int attempts = 0;
			boolean guessed = false;

			System.out.println("Guess the number between 1 and 100 (Max attempts: 5)");

			while (attempts < 5) {
				System.out.print("Enter your guess: ");
				int guess = sc.nextInt();
				attempts++;

				if (guess == number) {
					System.out.println("You won in attempt: " + attempts);
					guessed = true;
					break;
				} else if (guess < number) {
					System.out.println("Sorry, too low.");
				} else {
					System.out.println("Sorry, too high.");
				}
			}

			if (!guessed) {
				System.out.println("You lost! The correct number was: " + number);
			}

			System.out.print("Do you want to play again? (yes/no): ");
			playAgain = sc.next();
		}

		System.out.println("Game Over!");
		sc.close();
	}
}
