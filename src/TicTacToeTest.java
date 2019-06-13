/**
 * Projektname:            TicTacToeNeu
 * Programmname:
 * Version: 				1.0
 * Erstellungsdatum:		13.06.2019
 * Autor:   				Kenan Sezgin
 **/
public class TicTacToeTest {

    public static void main(String[] args) {
        char[] arr = new char[10];

        TicTacToe ob = new TicTacToe();
        System.out.println(ob.whoGoesFirst());

        ob.printBoard(arr);
        ob.inputPlayerLetter();



    }
}
