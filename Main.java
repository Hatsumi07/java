// import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        //object that help to receive input from the user
        Scanner scanner = new Scanner(System.in);

        // instance of arcade class
        Arcade myArcade = new Arcade(scanner);
        myArcade.Dealer();

        scanner.close();
    }
}