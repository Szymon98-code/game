import javax.swing.*;

public class gra extends JFrame
{
    public static void nowaGra() throws InterruptedException{
        przyciskTab przycisk=new przyciskTab(10,10,10);
        plansza plansza=new plansza(przycisk,435,520);
        plansza.time.start();
    }
    public static void main()throws InterruptedException{
        nowaGra();
    }
}