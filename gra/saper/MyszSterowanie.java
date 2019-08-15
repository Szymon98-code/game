import java.awt.*;  
import java.awt.event.*; 
import javax.swing.ImageIcon; 
public class MyszSterowanie extends Frame implements MouseListener{
    plansza plansza;
    
    public MyszSterowanie(plansza plansza){
        this.plansza=plansza;    
       
    }

    public void mouseClicked(MouseEvent e) { 
        int z=e.getButton();
        Object x=e.getSource();
           
        if(z==e.BUTTON3){
            ImageIcon ikona_mina=new ImageIcon("wyk.PNG");
            ImageIcon ikona_zapytanie=new ImageIcon("zapytanie.JPG");
            for(int i=0;i<plansza.a.m;i++){
                for(int j=0;j<plansza.a.n;j++){
                    if(plansza.a.tab[i][j].czyOdsloniety!=true){
                        if(plansza.przyciski[i][j]==x&&plansza.a.tab[i][j].czyOznaczony==false&&plansza.a.tab[i][j].czyZapytanie==false){
                            plansza.przyciski[i][j].setIcon(ikona_mina);
                            plansza.a.tab[i][j].czyOznaczony=true;
                            plansza.ile_bomb--;
                            plansza.bomby.setText(Integer.toString(plansza.ile_bomb));
                        }
                        else if(plansza.przyciski[i][j]==x&&plansza.a.tab[i][j].czyOznaczony==true&&plansza.a.tab[i][j].czyZapytanie==false){
                            plansza.przyciski[i][j].setIcon(ikona_zapytanie);
                            plansza.a.tab[i][j].czyOznaczony=false;
                            plansza.a.tab[i][j].czyZapytanie=true;
                            plansza.ile_bomb++;
                            plansza.bomby.setText(Integer.toString(plansza.ile_bomb));
                        }
                        else if(plansza.przyciski[i][j]==x&&plansza.a.tab[i][j].czyOznaczony==false&&plansza.a.tab[i][j].czyZapytanie==true){
                            plansza.przyciski[i][j].setIcon(null);                            
                            plansza.a.tab[i][j].czyZapytanie=false;
                        }
                    }
                }
            }
        }
    }  
    public void mouseEntered(MouseEvent e) {}  
    public void mouseExited(MouseEvent e) {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {}  
}  