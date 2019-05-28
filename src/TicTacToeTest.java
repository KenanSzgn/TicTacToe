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
        System.out.println(ob.whoGoesFirst());
        System.out.println("hallo");

    }

}
