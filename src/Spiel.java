/**
 * Spiel Tic Tac Toe *
 * Programmname:			Spiel.java
 * Programmversion:		V 1.spielfeldBeginn
 * Erstellungsdatum:		28.04.2019
 * Programmierer:			Kenan Sezgin (s0559666)

import java.util.Scanner;
 */
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
//
public class Spiel {
    // Hier speichere ich die Koordinaten der X'e vom User
    int[] gespeicherteKombinationen = new int[9];

    // SpielfeldArray in der Groeße von 5x5: Eigentliches Spielfeld = 3x3
    // Das Spielfeld benoetigt aber eine Umrandung, um zu verhindern, das ich ein ArrayIndexOutOfBoundsException bekomme
    char[][] spielFeld = new char[5][5];

    // Das Spielfeld muss in der Mitte zentriert werden, deshalb erstelle ich folgende variablen für die For-Schleifen
    int spielfeldBeginn = 1;
    int spielfeldEnde = 3;


    Scanner in = new Scanner(System.in);

    // Parameterloser Standard-Konstruktor
    public Spiel() {
        super();
        System.out.println("Warnung! Parameterlosesr Standard-Konstruktor aufgerufen in Klasse " + this.getClass().getSimpleName());
    }

    // Konstruktor mit formalen Parametern
    public Spiel(char[][] spielFeld) {
        super();
        this.spielFeld = spielFeld;
        for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
            for (int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
                spielFeld[i][k] = '-';
            }
        }
    }

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Links nach Rechts
    public void forSchleifeVorwaertsZeilenweise() {
        for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
            for (int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
                if (spielFeld[i][k] == 'X' && spielFeld[i][k + 1] == 'X' && spielFeld[i][k + 2] == '-') {
                    spielFeld[i][k + 2] = 'O';
                }
            }
        }
    }

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Rechts nach Links
    public void forSchleifeRueckwaertsZeilenweise() {
        for (int i = spielfeldEnde - 1; i >= spielfeldBeginn; i--) {
            for (int k = spielfeldEnde - 1; k >= spielfeldBeginn; k--) {
                if (spielFeld[i][k] == 'X' && spielFeld[i][k - 1] == 'X' && spielFeld[i][k - 2] == '-') {
                    spielFeld[i][k - 2] = 'O';
                }
            }
        }
    }

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Oben nach Unten
    public void forSchleifeVorwaertsSpaltenweise() {
        for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
            for (int k = spielfeldBeginn; k <= spielFeld[i].length - 1; k++) {
                if (spielFeld[i][k] == 'X' && spielFeld[i + 1][k] == 'X' && spielFeld[i + 2][k] == '-') {
                    spielFeld[i + 2][k] = 'O';
                }
            }
        }
    }

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Unten nach Oben
    public void forSchleifeRueckwaertsSpaltenweise() {
        for (int i = spielfeldEnde - 1; i >= spielfeldBeginn; i--) {
            for (int k = spielFeld[i].length - 1; k >= spielfeldBeginn; k--) {
                if (spielFeld[i][k] == 'X' && spielFeld[i - 1][k] == 'X' && spielFeld[i - 2][k] == '-') {
                    spielFeld[i - 2][k] = 'O';
                }
            }
        }
    }

    // Ueberpruefe Gewinner-Methoden bzw. forschleifen

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Links nach Rechts
    public void gewinnerForSchleifeVorwaertsZeilenweise() {

        for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
            for (int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
                if (spielFeld[i][k] == 'X' && spielFeld[i][k+1] == 'X' && spielFeld[i][k+2] == 'X' ) {
                    System.out.println("X HAT GEWONNEN !!!" );
                }else  if (spielFeld[i][k] == 'O' && spielFeld[i][k+1] == 'O' && spielFeld[i][k+2] == 'O' ) {
                    System.out.println("O HAT GEWONNEN !!!" );
                }
            }
        }
    }

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Rechts nach Links
    public void gewinnerForSchleifeRueckwaertsZeilenweise() {
        for (int i = spielfeldEnde - 1; i >= spielfeldBeginn; i--) {
            for (int k = spielfeldEnde - 1; k >= spielfeldBeginn; k--) {
                if (spielFeld[i][k] == 'X' && spielFeld[i][k-1] == 'X' && spielFeld[i][k-2] == 'X' ) {
                    System.out.println("X HAT GEWONNEN !!!" );
                }else  if (spielFeld[i][k] == 'O' && spielFeld[i][k-1] == 'O' && spielFeld[i][k-2] == 'O' ) {
                    System.out.println("O HAT GEWONNEN !!!" );
                }
            }
        }
    }

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Oben nach Unten
    public void gewinnerForSchleifeVorwaertsSpaltenweise() {
        for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
            for (int k = spielfeldBeginn; k <= spielFeld[i].length - 2; k++) {
                if (spielFeld[i][k] == 'X' && spielFeld[i-1][k] == 'X' && spielFeld[i-2][k] == 'X') {
                    System.out.println("X HAT GEWONNEN !!!" );
                }else  if (spielFeld[i][k] == 'O' && spielFeld[i-1][k] == 'O' && spielFeld[i-2][k] == 'O' ) {
                    System.out.println("O HAT GEWONNEN !!!" );
                }
            }
        }
    }

    // Wenn zwei Zellen mit X belegt sind, setze das O in die nächste Zelle
    // Von Unten nach Oben
    public void gewinnerForSchleifeRueckwaertsSpaltenweise() {
        for (int i = spielfeldEnde - 1; i >= spielfeldBeginn; i--) {
            for (int k = spielFeld[i].length - 2; k >= spielfeldBeginn; k--) {
                if (spielFeld[i][k] == 'X' && spielFeld[i-1][k] == 'X' && spielFeld[i-2][k] == 'X') {
                    System.out.println("X HAT GEWONNEN !!!" );
                }else  if (spielFeld[i][k] == 'O' && spielFeld[i-1][k] == 'O' && spielFeld[i-2][k] == 'O' ) {
                    System.out.println("O HAT GEWONNEN !!!" );
                }
            }
        }
    }

    // Spielfeldausgabe
    public void spielfeldAusgabe() {
        gibtEsEinenGewinner();
        System.out.println("*" + "|" + spielfeldBeginn + "|" + "|" + "2" + "|" + "|" + "3" + "|*");
        for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
            System.out.print(i);
            for (int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
                System.out.print("|" + spielFeld[i][k] + "|");
            }
            // mit dem Code System.out.println(); erzwingen wir, das nach Ende einem inneren Arrays
            // eine neue Zeile erzeugt wird.
            System.out.println();
        }
        System.out.println("*");
    }

    // Spiler macht seinen Zug
    public void spielZugUser() {
        System.out.println("Platzieren Sie bitte Ihr X");
        System.out.println("Bitte die Zeile eingeben");
        int z = in.nextInt();
        System.out.println("Bitte die Spalte eingaben");
        int s = in.nextInt();
        if (spielFeld[z][s] != '-') {
            System.out.println("Dieses Feld ist schon belegt, bitte plazieren Sie Ihr X wo anders");
            spielZugUser();
        } else {
            spielFeld[z][s] = 'X';
        }
    }

    public void spielZugComputer() {
        // 5 + (Math.random() * (10 - 5))
        // 1 + (int)(Math.random() * ((3 - 1) + 1))
        //rand.nextInt((max - min) + 1) + min;
        //int differenz = obereGrenze - untereGrenze;
        //int zufallZahl = (int) (Math.random() * differenz) + untereGrenze;

        int differenz = 3 - 1;
        int number1 = (int) (Math.random() * differenz) + 1;
        int number2 = (int) (Math.random() * differenz) + 1;


        // Wenn X fast gewinnt versperre ihm den Weg
        // undzwar wenn X verläuft ...
        // Von Links nach Rechts
        forSchleifeVorwaertsZeilenweise();
        // Von Rechts nach Links
        forSchleifeRueckwaertsZeilenweise();
        // Von Oben nach Unten
        forSchleifeVorwaertsSpaltenweise();
        // Von Unten nach Oben
        forSchleifeRueckwaertsSpaltenweise();

        // Diagonal von Oben Links nach Unten Rechts
        if (spielFeld[spielfeldBeginn][spielfeldBeginn] == 'X' && spielFeld[2][2] == 'X') {
            spielFeld[3][3] = 'O';
            // Diagonal von Unten Rechts nach Oben Links
        } else if (spielFeld[3][3] == 'X' && spielFeld[2][2] == 'X') {
            spielFeld[spielfeldBeginn][spielfeldBeginn] = 'O';
            // Diagonal von Oben Rechts nach Unten Links
        } else if (spielFeld[spielfeldBeginn][3] == 'X' && spielFeld[2][2] == 'X') {
            spielFeld[3][spielfeldBeginn] = 'O';
            // Diagonal von Unten Links nach Oben Rechts
        } else if (spielFeld[3][spielfeldBeginn] == 'X' && spielFeld[2][2] == 'X') {
            spielFeld[spielfeldBeginn][3] = 'O';

            // ansonsten setze das O an eine zufällige Stelle
        } else if (spielFeld[number1][number2] == '-') {
            spielFeld[number1][number2] = 'O';
        } else {

            System.out.println("Ende");
            System.out.println("Zufalls Zeile: "+number1);
            System.out.println("Zufalls Spalte: "+number2);
        }

//		} else if (spielFeld[number3][number4] == '-') {
//			spielFeld[number3][number4] = 'O';
//		}
    }

    public void gibtEsEinenGewinner() {

        // Ausgabe das X gewonnen hat
        gewinnerForSchleifeVorwaertsZeilenweise();
        gewinnerForSchleifeVorwaertsSpaltenweise();
        gewinnerForSchleifeRueckwaertsZeilenweise();
        gewinnerForSchleifeRueckwaertsSpaltenweise();

        // Ueberpruefe Diagonale von Links nach Rechts
        if (spielFeld[spielfeldBeginn][spielfeldBeginn] == 'X' && spielFeld[2][2] == 'X' && spielFeld[3][3] == 'X') {
            System.out.println("X hat gewonnen!!! ");
            // Ueberpruefe Diagonale von Rechts nach Links
        } else if (spielFeld[spielfeldBeginn][3] == 'X' && spielFeld[2][2] == 'X' && spielFeld[3][spielfeldBeginn] == 'X') {
            System.out.println("X hat gewonnen!!! ");

            // Ausgabe das O gewonnen hat
            // Ueberpruefe Diagonale von Links nach Rechts
        } else if (spielFeld[spielfeldBeginn][spielfeldBeginn] == 'O' && spielFeld[2][2] == 'O' && spielFeld[3][3] == 'O') {
            System.out.println("O hat gewonnen!!! ");
            // Ueberpruefe Diagonale von Rechts nach Links
        } else if (spielFeld[spielfeldBeginn][3] == 'O' && spielFeld[2][2] == 'O' && spielFeld[3][spielfeldBeginn] == 'O') {
            System.out.println("O hat gewonnen!!! ");


        } else {
            System.out.println("Bis jetzt noch kein Gewinner.");
        }
    }
}




// An disem Code noch weiter arbeiten, überprüft ob es schon einen gewinner gibt.

//	public void GewinnerForSchleifeVorwaertsZeilenweise() {
//		for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
//			for (int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
//				if(spielFeld[i][k] == 'X') {
//					System.out.println("X hat gewonnen!!! ");
//				}
//		}
//	}
//	
//		for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
//			for (int k = spielfeldBeginn; k <= spielFeld[i].length; k++) {
//	public void GewinnerForSchleifeVorwaertsSpaltenweise() {
//				if(spielFeld[i][k] == 'X') {
//					System.out.println("X hat gewonnen!!! ");
//				}
//			}
//		}
//	}

//	public void spielZugComputer() {
//		// Wenn X fast gewinnt versperre ihm den Weg
//		if (spielFeld[spielfeldBeginn][spielfeldBeginn] == 'X' && spielFeld[1][1] == 'X') {
//			spielFeld[2][2] = 'O';
//
//		} else if (spielFeld[2][spielfeldBeginn] == 'X' && spielFeld[1][1] == 'X') {
//			spielFeld[spielfeldBeginn][2] = 'O';
//
//		} else if (spielFeld[spielfeldBeginn][spielfeldBeginn] == 'X' && spielFeld[spielfeldBeginn][1] == 'X') {
//			spielFeld[spielfeldBeginn][2] = 'O';
//
//		} else if (spielFeld[1][spielfeldBeginn] == 'X' && spielFeld[1][1] == 'X') {
//			spielFeld[1][2] = 'O';
//
//		} else if (spielFeld[2][spielfeldBeginn] == 'X' && spielFeld[2][1] == 'X') {
//			spielFeld[2][2] = 'O';
//
//		} else if (spielFeld[spielfeldBeginn][spielfeldBeginn] == 'X' && spielFeld[1][spielfeldBeginn] == 'X') {
//			spielFeld[2][spielfeldBeginn] = 'O';
//
//		} else if (spielFeld[spielfeldBeginn][1] == 'X' && spielFeld[1][1] == 'X') {
//			spielFeld[2][1] = 'O';
//
//		} else if (spielFeld[spielfeldBeginn][2] == 'X' && spielFeld[1][2] == 'X') {
//			spielFeld[2][2] = 'O';
//		// ansonsten setze das O an eine zufällige Stelle
//		} else {
//			int number = (int) (Math.random() * 2);
//			int number2 = (int) (Math.random() * 2);
//			if(spielFeld[number][number2] == '-') {
//				spielFeld[number][number2] = 'O';
//
//			}else {
//				int number3 = (int) (Math.random() * 2);
//				int number4 = (int) (Math.random() * 2);
//				if(spielFeld[number3][number4] == '-') {
//					spielFeld[number3][number4] = 'O';
//			}
//		}
//	}

//		for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
//			for (int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
// if(spielFeld[i][k] == '\u0000') { ich dachte das dieser ASCI-Code: \u0000
// eine Leerstelle
// bzw. den Initialwert eines char-Arrays darstellen soll
// leider funtioniert es nicht, stattdessen werde ich das Spielfeld mit
// Bindestrichen initialisieren
// Lösung für das Problem

//	public boolean pruefeUser() {
//		// Speichere die Koordinaten der X'e vom User in das Array
//		// gespeicherteKombinationen
//		// undzwar abwechselnd i und k daraus folgt array mit |i|k|i|k|i|k|i|k|
//		for (int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
//			for (int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
//				if (spielFeld[i][k] == 'X') {
//					gespeicherteKombinationen[i] = i;
//					gespeicherteKombinationen[i++] = k;
//				}
//			}
//
//		}
//		return false;
//	}
//		int zaehler = spielfeldBeginn;
//		for(int i = spielfeldBeginn; i <= spielfeldEnde; i++) {
//			for(int k = spielfeldBeginn; k <= spielfeldEnde; k++) {
//				if(spielFeld[i][k] == 'X') {
//					zaehler++;
//				}
//			}
//		}
//		
//		
//		return false;
//	}