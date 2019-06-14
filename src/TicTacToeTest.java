/**
 * Projektname:            TicTacToeNeu
 * Programmname:
 * Version: 				1.0
 * Erstellungsdatum:		13.06.2019
 * Autor:   				Kenan Sezgin
 **/
public class TicTacToeTest {

    public static void main(String[] args) {
        TicTacToe ob = new TicTacToe();
        char[] board = new char[10];

        ob.printBoard(board);
        char playerLetter = ob.inputPlayerLetter();
        String first = ob.whoGoesFirst();
        // Nur zur Probe
        System.out.println(first);

        if(first == "Player"){
            ob.getPlayerMove(board);
        }else{
            ob.getComputerMove(board,playerLetter);
        }

    }
}
