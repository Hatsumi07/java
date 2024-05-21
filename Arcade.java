import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
// import java.util.Iterator;
// import java.util.List;
// import javax.xml.crypto.Data;
public class Arcade {
    Scanner myScanner;
    ArrayList<User> playersList = new ArrayList<User> ();
    int rounds = 3;

    public Arcade(Scanner scanner) {
        myScanner = scanner;
    }

    // Method that handles the game and how users interact with it
    public void Dealer() {
        this.welcome();
        this.startGame();
        this.requestReport();
    }

    // Method that asks players if they would like a report of the game
    public void requestReport() {
        System.out.println("Would you like a report about the game? yes/no");
        String requestReport = myScanner.nextLine();
        if(requestReport.equalsIgnoreCase("yes")) {
            this.generateReport();
        } else if(requestReport.equalsIgnoreCase("no")) {
            System.out.println("GOODBYE!");;
        } else {
            this.requestReport();
        }
    }

    // Method that generates a report of the game
    public void generateReport() {
        System.out.println("Please type a name for your report:");
        String reportName = myScanner.nextLine();
        try {
            FileWriter report = new FileWriter(reportName);
            for (User player : playersList) {
                report.write(player.playerName + " | " + player.avatar + " | " + "SCORE: " + player.score + "\n");   
            }
            report.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method that creates new instances of User object
    public void createNewPlayer() {
        // Method that creates and adds a new player
        User newPlayer = new User(myScanner);
        newPlayer.requestPlayerInfo();
        playersList.add(newPlayer);
        var playerIdx = playersList.indexOf(newPlayer);
        newPlayer.index = playerIdx;
    }

    // Method that displays players and their info
    public void showPlayers() {
        playersList.forEach((n) -> n.displayPlayerInfo());
    }

    // Mehtod that asks user(s) the play-mode and calls the createNewPlayer() method according to it.
    public void welcome() {
        System.out.println("WELCOME TO THE ARCADE!!!\nPress (A) to play alone or (G) to play in group");
        String answer = myScanner.nextLine();
        if (answer.equalsIgnoreCase("a")) {
            this.createNewPlayer();
            this.showPlayers();
        } 
        
        else if (answer.equalsIgnoreCase("g")) {
            System.out.println("How many people will play?");
            var numPlayers = Integer.parseInt(myScanner.nextLine());

            for (int i = 0; i < numPlayers; i++) {
                this.createNewPlayer();
            }
            this.showPlayers();
        } 
        else {
            this.welcome();
        }
    }

    // Method that executes the game
    public void startGame() {
        System.out.println("Hi! Are you ready to play? yes/no: ");
        String answer = myScanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Play the game!");
            for(var i = 0; i < rounds; i++) {
                System.out.println("ROUND " + (i+1));
                this.playRound();
            }
        } 
        else if (answer.equalsIgnoreCase("no")) {
            System.out.println("Goodbye!");
        } 
        else {
            this.startGame();
        }
    }

    // Method that handles every round
    public void playRound() {
        for(User player : playersList) {
                System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||Player " + player.playerName + "'s turn||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                player.playGame();
            }
    } 
}
