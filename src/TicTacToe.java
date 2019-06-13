import java.util.Random;
import java.util.Scanner;

/**
 * Projektname:             TicTacToeNeu
 * Programmname:
 * Version: 				1.0
 * Erstellungsdatum:		13.06.2019
 * Autor:   				Kenan Sezgin
 **/
public class TicTacToe {

    char[] board = new char[10];
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    public void printBoard(char[] board) {
        System.out.println(board[7] + " | " + board[8] + " | " + board[9] + " | ");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6] + " | ");
        System.out.println(board[1] + " | " + board[2] + " | " + board[3] + " | ");
    }

    // Lets the player select the desired letter.
    // Returns the player letter
    public char inputPlayerLetter() {
        char letter = ' ';
        while (letter != 'X' || letter != 'O') {
            System.out.println("Do you want to be X or O?");
            letter = in.next().toUpperCase().charAt(0);
        }
        return letter;
    }

    // Randomly choose who has the first move
    public String whoGoesFirst() {
        int r = rand.nextInt(2);
        System.out.println(r);
        if (r == 0) {
            return "Player";
        } else {
            return "Computer";
        }
    }


}
