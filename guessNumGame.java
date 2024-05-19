import java.util.Scanner;

public class guessNumGame{
        // variable to store the value of the random number
        final int secretNum = (int) (Math.random() * 11);

        // variable to store the number of attempts per game
        int attempts = 3;

        // variable to store the input from the user}
        int guessedNum;

        // variable (helperMsg) returns a message that tells the user 
        // their status in the game
        String helperMsg = "I will print hints!"; 

        boolean guessIsCorrect = false;

        Scanner myScanner;

    public guessNumGame(Scanner scanner){
        myScanner = scanner;
    }

    public boolean canPlay() {
        if(guessIsCorrect) {
            return false;
        } else {
            if(attempts == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void play() {
        if (this.canPlay()) {
            this.requestGuess();
            this.checkGuess();
            // this.helper();
            System.out.println(this.helperMsg);
            this.play();
        }
    }

    public void checkGuess() {
        --this.attempts;
        if(secretNum == guessedNum) {
            guessIsCorrect = true;
            this.helperMsg = "Guess is correct!";

        } else {
            guessIsCorrect = false;
            this.helper();
        }
    }

    public void helper() {
        if (attempts == 0) {
            if (guessedNum > secretNum) {
                this.helperMsg = "Too high!\nGAME OVER";
            } else if (guessedNum < secretNum) {
                this.helperMsg = "Too low!\nGAME OVER";
            }
            // this.helperMsg = "GAME OVER!";
        } else if (guessedNum > secretNum) {
            this.helperMsg = "Too high!\nYou have " + this.attempts + " more attempts.";
        } else if (guessedNum < secretNum) {
            this.helperMsg = "Too low!\nYou have " + this.attempts + " more attempts.";
        }
    }

    public void requestGuess() {
        // Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess: "); 
        int guess = myScanner.nextInt();   

        this.guessedNum = guess;
    }
}