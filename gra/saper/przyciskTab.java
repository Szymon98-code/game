import java.util.*;
public class przyciskTab
{
    public przycisk tab[][];
    int bomby;
    int n;
    int m;
    public przyciskTab(int n, int m, int bomby){
        tab=new przycisk[n][m];
        this.bomby=bomby;
        this.n=n;
        this.m=m;
        for(int i=0; i<tab.length;i++){
            for(int j=0; j<tab.length;j++){
                tab[i][j]=new przycisk();
            }

        }
        Random losX=new Random();
        Random losY=new Random();

        int x=0,y=0;
        int ile=0;
        while(ile!=bomby){
            x=losX.nextInt(n-1);
            y=losY.nextInt(m-1);
            if(tab[x][y].wartosc!=9){
                tab[x][y].wartosc=9;
                if(y+1<m&&tab[x][y+1].wartosc!=9)tab[x][y+1].wartosc++;
                if(y-1>=0&&tab[x][y-1].wartosc!=9)tab[x][y-1].wartosc++;
                if(x-1>=0&&tab[x-1][y].wartosc!=9)tab[x-1][y].wartosc++;
                if(x+1<n&&tab[x+1][y].wartosc!=9)tab[x+1][y].wartosc++;
                if(x+1<n&&y+1<m&&tab[x+1][y+1].wartosc!=9)tab[x+1][y+1].wartosc++;
                if(x-1>=0&&y-1>=0&&tab[x-1][y-1].wartosc!=9)tab[x-1][y-1].wartosc++;
                if(x-1>=0&&y+1<m&&tab[x-1][y+1].wartosc!=9)tab[x-1][y+1].wartosc++;
                if(x+1<n&&y-1>=0&&tab[x+1][y-1].wartosc!=9)tab[x+1][y-1].wartosc++;
                ile++;
            }
            else 
                continue; 
        }
    }

    public String toString(){
        String bufor="";
        for(int i=0; i<tab.length;i++){
            for(int j=0; j<tab.length;j++){
                bufor+=tab[i][j]+" ";
            }
            bufor+="\n";
        }
        return bufor;
    }
}