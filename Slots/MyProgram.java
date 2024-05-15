import java.util.Scanner;
public class MyProgram
{
    public static void main(String[] args)
    {
        // This is a new comment!
        Scanner input = new Scanner(System.in);
        double balance = 0.0;
        SlotMachine m1 = new SlotMachine(0, false);
        //m1.setLuck(-8); // this is all it takes to make hitting the jackpot flat-out impossible.
        //m1.roll();
        //m1.setDebug(true);
        //m1.setLuck(993); // and this is how you make it impossible to get anything but the jackpot.
        //m1.roll();
        for (int i = 0; i < 10; i++)
        {
            m1.roll();
        }
    }
}
