import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon; 

public class PrzyciskiSterowanie extends Frame implements ActionListener 
{   plansza plansza;
    int odkryte;

    public PrzyciskiSterowanie(plansza plansza){
        this.plansza=plansza;
        odkryte=0;
    }

    public void actionPerformed(ActionEvent e){
        Object z=e.getSource();

        if(z==plansza.nowaGra){             
            plansza.nowaGra(plansza.a.m, plansza.a.n, plansza.a.bomby, plansza.width, plansza.height);
            //plansza.time.start();
        }
        else if(z==plansza.latwy){
            plansza.nowaGra(10,10,10,435,520);
        }
        else if(z==plansza.sredni){
            plansza.nowaGra(15,15,30,635,720);
        }       
        else if(z==plansza.trudny){
            plansza.nowaGra(18,18,60,755,840);
        }
        for(int i=0;i<plansza.a.m;i++){
            for(int j=0;j<plansza.a.n;j++){
                if(z==plansza.przyciski[i][j]){
                    plansza.przyciski[i][j].setIcon(null);

                    if(plansza.a.tab[i][j].wartosc==9){
                        ImageIcon ikona=new ImageIcon("mina.JPG");
                        plansza.przyciski[i][j].setIcon(ikona);
                        plansza.koniecGry();
                    }
                    else if(plansza.a.tab[i][j].wartosc==0)plansza.ods_zer(i,j);
                    else{
                        plansza.przyciski[i][j].setText(Integer.toString(plansza.a.tab[i][j].wartosc));
                        plansza.a.tab[i][j].czyOdsloniety=true;
                        plansza.przyciski[i][j].setEnabled(false);
                        odkryte++;}
                    if(odkryte==(plansza.a.m*plansza.a.n)-plansza.a.bomby)System.out.println("suckes");
                }
            }
        }
    }
}
