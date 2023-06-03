import java.util.*;
import java.util.random.*;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random_num = new Random();
        int round = 1;
        int score = 0;
        int maxAttempts = 0;
        int maxRounds = 3;
        System.out.println("!!!....Welcome to Number Guessing Game...!!!");
        while (round <= maxRounds) {
            System.out.println("Enter level to start the Game to score![for Easy:-->0 , Medium:-->1 , Hard:-->2]");
            System.out.print("level = ");
            int level = sc.nextInt();
            if (level == 0) {
                maxAttempts = 10;
            } else if (level == 1) {
                maxAttempts = 7;
            } else if (level == 2) {
                maxAttempts = 5;
            } else {
                System.out.println("Entered Invalid level");
            }
            int systemgenerated = random_num.nextInt(100) + 1;
            int attempt = 0;
            System.out.println("oho! Welcome to Round " + round + ".");
            System.out
                    .println("System has generated number between 1 and 100. Guess the number and collect the points");
            System.out.println("........................");

            while (attempt < maxAttempts) {
                System.out.print("Enter your guess number: ");
                int guess = sc.nextInt();
                attempt++;
                if (guess == systemgenerated) {
                    System.out.println("\noho! Perfact Guess! You took " + attempt + " attempts.");
                    int Round_score = maxAttempts - attempt + 1;
                    System.out.println("You earned " + Round_score + " points in round " + round + ".");
                    score = score + Round_score;
                    break;
                } else {
                    System.out.println("\nIncorrect. You have " + (maxAttempts - attempt) + " attempts left.");
                    if ((maxAttempts - attempt) == 0) {
                        System.out.println(
                                "oops! You failed to guess the number. The system generated was " + systemgenerated
                                        + ".");
                        System.out.println("........................");

                        continue;
                    }
                    if (guess < systemgenerated) {
                        System.out.println("Too low. Guess again: \n");
                        System.out.println("........................");
                    } else {
                        System.out.println("Too high. Guess again: \n");
                        System.out.println("........................");

                    }
                }
            }
            if (round < maxRounds) {
                System.out.println("Lets play another round.Be the highest scorrer!\n");
            }
            round++;

        }
        System.out.println("\nFINAL SCORE: " + score);

    }
}
