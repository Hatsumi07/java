import java.util.Scanner;

public class guessNumGame{
        // variable to store the value of the random number
        final int secretNum = (int) (Math.random() * 11);

        // variable to store the number of attempts per game
        int attempts = 3;

        // variable to store the user's guess
        int guessedNum;

        // variable (helperMsg) returns a message that tells the user 
        // their status in the game
        String helperMsg = "I will print hints!"; 

        boolean guessIsCorrect = false;

        Scanner myScanner;

    public guessNumGame(Scanner scanner){
        myScanner = scanner;
    }

    // detremines whether users can continue playing
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

    // Only allows users that can play the game to continue playing
    public void play() {
        if (this.canPlay()) {
            this.requestGuess();
            this.checkGuess();
            // this.helper();
            System.out.println(this.helperMsg);
            this.play();
        }
    }

    
    // compares the user's guess to the number generated randomly
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
    
    // updates the helperMsg variable according to player's status 
    // in the game
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

    // accepts input from the user and assigns the value of the input 
    // to the guessNum variable
    public void requestGuess() {
        // Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess: "); 
        int guess = myScanner.nextInt();   

        this.guessedNum = guess;
    }
}