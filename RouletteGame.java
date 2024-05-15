import java.util.Random;

public class RouletteGame {
    public static void main(String[] args) {
        
        int[] redNumbers = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        int[] blackNumbers = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        int[] oddNumbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
        int[] evenNumbers = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        int[] firstThird = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] secondThird = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        int[] thirdThird = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};

        
        Random random = new Random();

        
        int spinResult = random.nextInt(38); 

    
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
