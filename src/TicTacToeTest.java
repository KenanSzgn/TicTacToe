/**
 * Projektname:            Tic Tac Toe
 * Programmname:
 * Version: 				1.0
 * Erstellungsdatum:		28.05.2019
 * Autor:   				Kenan Sezgin
 **/
public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe ob = new TicTacToe();
        String[] arr = new String[10];
        ob.printBoard(arr);
    // start ab hier

        char[] playerLetter;
        char[] computerLetter;
        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean hilfe = true;
        while (hilfe) {
            // setze das Spielbrett zurück
            char[] theBoard = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
            playerLetter = ob.inputPlayerLetter();
            computerLetter = ob.inputPlayerLetter();
            String turn = ob.whoGoesFirst();
            System.out.println("The "+turn+" will go first.");


           boolean gameIsPlaying = true;
           while (gameIsPlaying){

           }
        }




    }

}
