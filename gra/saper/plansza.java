import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;
public class plansza extends JFrame 
{
    JButton[][] przyciski;
    przyciskTab a;
    int szerokosc=10;
    int wysokosc=50;
    JButton nowaGra=new JButton("Nowa gra");
    JLabel bomby=new JLabel();
    JLabel czas=new JLabel();
    MyszSterowanie s=new MyszSterowanie(this);
    PrzyciskiSterowanie p=new PrzyciskiSterowanie(this);
    Czas time=new Czas(this);
    JMenuBar menu;
    JMenu gra, poziomy;
    JMenuItem  najlepsze_wyniki, latwy, sredni, trudny, wyjscie;
    int width,height;
    int ile_bomb;
    public plansza(przyciskTab a, int width, int height){
        this.width=width;
        this.height=height;
        przyciski=new JButton[a.n][a.m];
        setSize(width, height);
        setTitle("SAPER");
        setLayout(null);
        ile_bomb=a.bomby;
        this.a=a;

        for(int i=0;i<przyciski.length;i++)
            for(int j=0;j<przyciski.length;j++){
                przyciski[i][j]=new JButton();

            }
        for(int i=0;i<przyciski.length;i++){
            for(int j=0;j<przyciski[0].length;j++){
                add(przyciski[i][j]);
                przyciski[i][j].setBounds(szerokosc, wysokosc, 40, 40);
                przyciski[i][j].addActionListener(p);
                przyciski[i][j].addMouseListener(s);
                szerokosc+=40;
            }
            wysokosc+=40;
            szerokosc=10;
        }  
        ImageIcon usmiechnieta=new ImageIcon("usmiechnieta.JPG");
        nowaGra=new JButton(usmiechnieta);
        //Font font=new Font("Helvetica", Font.BOLD, 10);
        //nowaGra.setFont(font);
        nowaGra.setBounds((width/2)-20, 5, 40, 40);

        nowaGra.addActionListener(p);

        add(nowaGra);

        bomby.setBounds(10, 5, 40, 40);
        bomby.setText(Integer.toString(a.bomby));
        add(bomby);
        czas.setBounds(width-35, 5, 40, 40);
        czas.setText(Integer.toString(time.k));
        add(czas);

        menu=new JMenuBar();
        gra=new JMenu("Gra");
        setJMenuBar(menu);
        menu.add(gra);

        najlepsze_wyniki=new JMenuItem("Najlepsze wyniki");
        latwy=new JMenuItem("Łatwy");
        sredni=new JMenuItem("Średni");
        trudny=new JMenuItem("Trudny");
        poziomy=new JMenu("Poziomy");
        poziomy.add(latwy);
        poziomy.add(sredni);
        poziomy.add(trudny);

        latwy.addActionListener(p);
        sredni.addActionListener(p);
        trudny.addActionListener(p);
        gra.add(poziomy);

        poziomy.addActionListener(p);
        najlepsze_wyniki.addActionListener(p);
        gra.add(najlepsze_wyniki);
        gra.addSeparator();

        wyjscie=new JMenuItem("Wyjście");
        wyjscie.addActionListener(p);
        gra.add(wyjscie);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
    }

    public void nowaGra(int szerokosc, int wysokosc, int bomby,int width, int height){
        setVisible(false);
        przyciskTab przycisk=new przyciskTab(szerokosc,wysokosc,bomby);
        plansza plansza=new plansza(przycisk,width,height);       
        plansza.time.start();

    }

    public void koniecGry(){
        ImageIcon smutna=new ImageIcon("smutna.PNG");
        nowaGra.setIcon(smutna);
        for(int k=0; k<a.m;k++){
            for(int l=0;l<a.n;l++){
                przyciski[k][l].setEnabled(false);
            }
        }
        time.stoop();
    }

    public void ods_zer(int i, int j){
        if(i<0||i>przyciski.length-1)return;
        if(j<0||j>przyciski.length-1)return;
        if(a.tab[i][j].czyOdsloniety==true)return;
        if(a.tab[i][j].wartosc!=9&&a.tab[i][j].czyOdsloniety==false){
            if(a.tab[i][j].wartosc==0)przyciski[i][j].setText("");
            else przyciski[i][j].setText(Integer.toString(a.tab[i][j].wartosc));
            a.tab[i][j].czyOdsloniety=true;
            przyciski[i][j].setEnabled(false);
            p.odkryte++;
        }       
        if(a.tab[i][j].wartosc!=0)return;
        ods_zer(i-1,j-1);
        ods_zer(i+1,j+1);
        ods_zer(i-1,j);
        ods_zer(i,j-1);
        ods_zer(i+1,j);
        ods_zer(i,j+1);
        ods_zer(i-1,j+1);
        ods_zer(i+1,j-1);
    }

    public void sukces(){

    }
}