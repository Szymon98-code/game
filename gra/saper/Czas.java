
public class Czas extends Thread
{
    boolean stop=false;
    int k;
    plansza plansza;
    public Czas(plansza plansza){
        this.plansza=plansza;
        k=0;}

    public void run(){

        while(stop!=true){
            plansza.czas.setText(Integer.toString(k));
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);} 
            k++;
        }
    }

    public void stoop(){
        stop=true;}
}
