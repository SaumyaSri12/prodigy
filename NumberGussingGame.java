// TASK 2

import java.util.Random;
import java.util.Scanner;

public class NumberGussingGame {

    public static void main(String[] args) {
        playNumberGuessingGame();
    }

    public static void playNumberGuessingGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;

        int userGuess;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            System.out.print("Enter your guess (between 1 and 100): ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please enter a valid guess between 1 and 100.");
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            }
        } while (userGuess != randomNumber);

        scanner.close();
    }
}
