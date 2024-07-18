import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attempts = 5;
        int rounds = 0;
        int score = 0;
        
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("A random number between " + minRange + " and " + maxRange + " has been generated.");
            
            int guess;
            boolean guessedCorrectly = false;
            
            while (attempts > 0 && !guessedCorrectly) {
   System.out.print("Enter your guess (" + attempts + " attempts left): ");
                guess = scanner.nextInt();
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    guessedCorrectly = true;
                    score++;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                
                attempts--;
            }
            
            if (!guessedCorrectly) {
                System.out.println("Out of attempts. The correct number was: " + randomNumber);
            }
            
            rounds++;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game Over! You played " + rounds + " round(s) and your final score is: " + score);
 scanner.close();
    }
}