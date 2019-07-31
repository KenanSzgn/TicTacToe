
public class SpielTest {

    public static void main(String[] args) {
        char[][] spielFeld = new char[5][5];
        Spiel ob1 = new Spiel(spielFeld);


        /**for (int i = 0; i < spielFeld.length; i++){
            for (int k = 0; k < spielFeld.length; k++){
                System.out.println("Zeile i: "+i);
                System.out.println("Spalte k: "+k);

            }
        }*/

        // ich muss hier oder in der Klasse Spiel eine while-Schleife verwenden, damit
        // wenn jemand gewonnen hat, das Spiel zu ende geht
        ob1.spielfeldAusgabe();
        ob1.spielZugUser();
        ob1.spielZugComputer();
        ob1.spielfeldAusgabe();

        ob1.spielZugUser();
        ob1.spielZugComputer();
        ob1.spielfeldAusgabe();

        ob1.spielZugUser();
        ob1.spielZugComputer();
        ob1.spielfeldAusgabe();

        ob1.spielZugUser();
        ob1.spielZugComputer();
        ob1.spielfeldAusgabe();

        ob1.spielZugUser();
        ob1.spielZugComputer();
        ob1.spielfeldAusgabe();
//
//		ob1.spielZugUser();
//		ob1.spielfeldAusgabe();
//
//		ob1.spielZugComputer();
//		ob1.spielfeldAusgabe();
//

//
    }

}
