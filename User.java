import java.util.Scanner;
public class User {
    Scanner myScanner;
    String playerName;
    String avatar;
    int score = 0;
    int index;

    public User(Scanner scanner) {
        myScanner = scanner;
    }

    // Requests player info to assign the input to the player's
    // attributes
    public void requestPlayerInfo() {
        System.out.println("Enter new player name:");
        String name = myScanner.nextLine();
        this.playerName = name;
        System.out.println("Choose avatar: \n1. V°.°V\n2. *V(^O^)V*\n3. (O¿O`)");
        var avatarNum = myScanner.nextLine();
        if (avatarNum.equals("1")) {
            this.avatar = "|V°.°V|";
        } else if (avatarNum.equals("2")) {
            this.avatar = "|*V(^O^)V*|";
        } else if (avatarNum.equals("3")) {
            this.avatar = "|(O¿O`)|";
        }
    }
    
    // Returns a string conatining player info
    public void displayPlayerInfo() {
        System.out.println(this.playerName + "'s avatar => " + this.avatar);
    }

    // Players property that allow them to play the game
    public void playGame() {
       guessNumGame  newGame = new guessNumGame(myScanner);
       System.out.println("This is the secret number: " + newGame.secretNum);
       newGame.play();
       if(newGame.guessIsCorrect) {
        score ++;
       }
       System.out.println(playerName + "'s score: " + score);
    }
}
