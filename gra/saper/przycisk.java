
public class przycisk
{
    Integer wartosc;
    boolean czyOznaczony, czyOdsloniety, czyZapytanie;
    public przycisk(){
        czyOznaczony=false;
        czyOdsloniety=false;
        czyZapytanie=false;
        wartosc=0;
    
    }
    public String toString(){
    String bufor="";
    bufor+=wartosc+" ";
    return bufor;
    }
}
