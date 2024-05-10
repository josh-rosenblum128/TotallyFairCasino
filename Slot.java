public class Slot
{
    private int luck; // shhh it's totally random
    private double val;
    private String panel;
    private String ePanel; // emoji panel, not electronic panel
    private double[] table = new double[7];
    public Slot(int luck)
    {
        this.luck = luck;
        this.val = 0.0;
        this.panel = "This message should not appear. If it does, I messed up somewhere."; // the default value should always be overwritten by a spin before being shown
        this.ePanel = "This message should not appear. If it does, I messed up somewhere."; // see above
        this.setLuck(luck); // it REALLY feels like this shouldn't work, but it does!
    }
    
    public String spin()
    {
        val = (Math.random() * 1000);
        if (val <= table[0])
        {
            panel = "orange"; // 🍊 (U+1F34A) technically it's a tangerine.
            ePanel = "🍊";
        }
        else if (val <= table[1])
        {
            panel = "banana"; // 🍌 (U+1F34C)
            ePanel = "🍌";
        }
        else if (val <= table[2])
        {
            panel = "cherry"; // 🍒 (U+1F352)
            ePanel = "🍒";
        }
        else if (val <= table[3])
        {
            panel = "lemon"; // 🍋 (U+1F34B)
            ePanel = "🍋";
        }
        else if (val <= table[4])
        {
            panel = "bell"; // 🔔 (U+1F514)
            ePanel = "🔔";
        }
        else if (val <= table[5])
        { // there doesn't seem to be a horseshoe emoji, so here's the next best thing: a horseshoe magnet.
            panel = "horseshoe"; // 🧲 (U+1F9F2)
            ePanel = "🧲";
        } // honestly, it's kind of funny to have a magnet instead of an actual horseshoe. 
        else if (val <= table[6])
        {
            panel = "diamond"; // 💎 (U+1F48E)
            ePanel = "💎";
        }
        else 
        {
            panel = "seven"; // 7 (U+...i'm not gonna find the alt code for a normal 7.)
            ePanel = "7"; // i couldn't find a 7 emoji that i liked
        }
        return panel;
    }
    
    // Warning: here be unfinished attempts at a curved random number generator. 
    // Inspect at your own peril. 
    // public double spin(int l)
    // {
    //     /* I don't know if there's a curved random function so i'll make my own.
    //     The end result of this is a number between 0 and 1. Higher luck values
    //     make it more likely for the number to be close to 0. */
    //     for (int i = 0; i < l; i++) 
    //     {
    //         val += Math.random();
    //     }
    //     val = ((val / l) - 0.5) * 2;
    //     if (val < 0)
    //     {
    //         val = -val;
    //     }
    //     return val;
    // }
    
    // public double spin2(int l)
    // {
    //     /* an attempt at a different way of curving random numbers. 
    //     */ 
    //     val = 0.0;
    //     for (int i = 1; i <= l; i++)
    //     {
    //         val += (2*Math.pow((1.0/3.0),i)) * Math.random();
    //     }
    //     return val;
    // }
    
    // public double spin3(int l)
    // {
    //     val = 0.0;
    //     while (Math.random() > (l / 10.0))
    //     {
    //         val += Math.random();
    //     }
    //     return val;
    // }
    
    public void printTable() // this prints the table of values used to determine what panel to generate
    {
        for (int i = 0; i < 7; i++)
        {
            System.out.println(i + ": " + table[i]);
        }
    }
    
    public void setLuck(int l)
    {
        luck = l;
        double a = 0.0;
        for (int i = 1; i <= 7; i++)
        {
            a += (Math.pow(0.5,i)) * 1000;
            table[i - 1] = a - luck;
        }
    }
    
    public double getVal()
    {
        return val;
    }
    
    public String getPanel()
    {
        return panel;
    }
    
    public String getEPanel()
    {
        return ePanel;
    }
}