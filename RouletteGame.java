import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class RouletteGame {

    private int money;

    public RouletteGame(int moneyIn) throws InterruptedException{
        money = moneyIn;
        Scanner input = new Scanner(System.in);

        while (true) {
        int numberBet = -1;
        int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        int[] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        int[] oddNumbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
        int[] evenNumbers = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        int[] firstThird = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] secondThird = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        int[] thirdThird = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        int bet;

        
        System.out.println("What would you like to bet on?");
        System.out.println("1. Red");
        System.out.println("2. Black");
        System.out.println("3. Number");
        System.out.println("4. First Third");
        System.out.println("5. Second Third");
        System.out.println("6. Third Third");
        System.out.println("7. Even");
        System.out.println("8. Odd");
        System.out.println("9. Exit");
        System.out.println("Input a number");
        int betType = input.nextInt();
        
        if (betType == 9) {
            break;
        }
        
        if (betType > 8) {
            System.out.println("Invalid Bet Type!");
            break;
        }

        if (betType == 3) {
            System.out.println("What number would you like to bet on?");
            System.out.println("00 is 37");
            numberBet = input.nextInt();
            if (numberBet > 37) {
                System.out.println("Invalid Choice");
                continue;
            }
        }
        
        System.out.println("How much would you like to bet?");
        System.out.println("You have $" + money);
        bet = input.nextInt();
        if (bet > money) {
            System.out.println("You do not have enough money to bet that much!");
            continue;
        }


        Random wheel = new Random();
       
        
        
        int spinResult = wheel.nextInt(38); 

        for (int i = 0; i < 32; i++) {
            System.out.print("\r");
            for (int j = 0; j < i%8; j++) {
                System.out.print("-");
            }
            System.out.print("*");
            for (int j = i%8 + 1; j < 8; j++ ) {
                System.out.print("-");
            }
            TimeUnit.MILLISECONDS.sleep(50);
        }
    
        if (spinResult == 0) {
            System.out.println("The ball lands on 0 (green).");
        } else if (spinResult == 37) {
            System.out.println("The ball lands on 00 (green).");
        } else {
            if (isInArray(redNumbers, spinResult)) {
                System.out.println("The ball lands on " + spinResult + " (red).");
            } else if (isInArray(blackNumbers, spinResult)) {
                System.out.println("The ball lands on " + spinResult + " (black).");
            }

            if (isInArray(oddNumbers, spinResult)) {
                System.out.println("The ball lands on an odd number.");
            } else if (isInArray(evenNumbers, spinResult)) {
                System.out.println("The ball lands on an even number.");
            }

            if (isInArray(firstThird, spinResult)) {
                System.out.println("The ball lands on the first third of the numbers (1-12).");
            } else if (isInArray(secondThird, spinResult)) {
                System.out.println("The ball lands on the second third of the numbers (13-24).");
            } else if (isInArray(thirdThird, spinResult)) {
                System.out.println("The ball lands on the third third of the numbers (25-36)");
            }
        }

        if (betType == 1) {
            if (isInArray(redNumbers, spinResult)) {
                money += bet;
                System.out.println("You Won!");
                System.out.println("You have $" + money);
            } else {
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        } else if (betType == 2) {
            if (isInArray(blackNumbers, spinResult)) {
                money += bet;
                System.out.println("You Won!");
                System.out.println("You have $" + money);
            } else {
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        } else if (betType == 3) {
            if (numberBet == spinResult) {
                money += bet;
                System.out.println("You Win!");
                System.out.println("You have $" + money);
            } else {
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        } else if (betType == 4) {
            if (isInArray(firstThird, spinResult)) {
                money += bet;
                System.out.println("You Win!");
                System.out.println("You have $" + money);
            } else {
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        } else if (betType == 5) {
            if (isInArray(secondThird, spinResult)) {
                money += bet;
                System.out.println("You Win!");
                System.out.println("You have $" + money);
            } else{
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        } else if (betType == 6) {
            if (isInArray(thirdThird, spinResult)) {
                money += bet;
                System.out.println("You Win!");
                System.out.println("You have $" + money);
            } else {
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        } else if (betType == 7) {
            if (isInArray(evenNumbers, spinResult)) {
                money += bet;
                System.out.println("You Win!");
                System.out.println("You have $" + money);
            } else {
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        } else if (betType == 8) {
            if (isInArray(oddNumbers, spinResult)) {
                money += bet;
                System.out.println("You Win!");
                System.out.println("You have $" + money);
            } else {
                money -= bet;
                System.out.println("You are a loser!");
                System.out.println("You have $" + money);
            }
        }
        if (money <= 0) {
            System.out.println("You are now broke!");
            System.out.println("Thanks for your money!");
            break;
        }
        }
    }

    public int getMoney() {
        return money;
    }
    
    public static boolean isInArray(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
