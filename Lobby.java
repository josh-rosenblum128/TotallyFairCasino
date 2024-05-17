import java.util.Scanner;

public class Lobby {
    public static void main(String[] args) throws InterruptedException{
        Scanner input = new Scanner(System.in);
        int balance = 1000;
        while (balance > 0) {
            System.out.println("You have $" + balance);
            System.out.println("Roulette, Slots, Blackjack or Quit");
            System.out.print("What would you like to do: ");
            String command = input.nextLine().toLowerCase();
            if (command.equals("roulette")) {
                RouletteGame rg = new RouletteGame(balance);
                balance = rg.getMoney();
            } else if (command.equals("slots")) {
                
            } else if (command.equals("blackjack")) {

            } else if (command.equals("quit")) {
                break;
            }

        }
        System.out.println("Thanks for playing!");
    }
}
