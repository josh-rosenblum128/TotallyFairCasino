import java.util.concurrent.*;

public class Animation {
    public static void main(String[] args) throws InterruptedException {
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
    }
}
