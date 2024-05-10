public class SlotMachine
{
    private Slot s1;
    private Slot s2;
    private Slot s3;
    private int machineLuck;
    private boolean debug;
    
    public SlotMachine(int machineLuck, boolean debug)
    {
        this.machineLuck = machineLuck;
        this.debug = debug;
        s1 = new Slot(machineLuck);
        s2 = new Slot(machineLuck);
        s3 = new Slot(machineLuck);
    }
    
    public void roll()
    {
        s1.spin();
        s2.spin();
        s3.spin();
        System.out.print(s1.getEPanel() + " " + s2.getEPanel() + " " + s3.getEPanel() + "\n");
        if (this.findMatch() == true)
        {
            if (s1.getPanel().equals("seven"))
            {
                System.out.println("JACKPOT!!!");
            }
            else
            {
                System.out.println("Match!");
            }
        }
        else 
        {
            System.out.println("------");
        }
        if (debug == true)
        {
            System.out.println("DEBUG: Luck table used:");
            s1.printTable(); // it only prints out the table for the first slot, but
        } // there should never be a situation where different slots have different luck tables
    }
    
    public boolean findMatch()
    {
        if (s1.getPanel().equals(s2.getPanel()) && s1.getPanel().equals(s3.getPanel()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setLuck(int l)
    {
        machineLuck = l;
        s1.setLuck(machineLuck);
        s2.setLuck(machineLuck);
        s3.setLuck(machineLuck);
        if (debug == true)
        {
            System.out.println("DEBUG: Luck has been updated to " + machineLuck);
        }
    }
    
    public void setDebug(boolean debugMode)
    {
        if (debugMode == true)
        {
            System.out.println("Activating debug mode...");
        }
        debug = debugMode;
    }
}
