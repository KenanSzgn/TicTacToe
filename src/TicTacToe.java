/**
 * Projektname:            Tic Tac Toe
 * Programmname:
 * Version: 				1.0
 * Erstellungsdatum:		28.05.2019
 * Autor:   				Kenan Sezgin
 **/
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner in = new Scanner(System.in);
    Random randomNumber = new Random();
    // Array fÃƒÂ¼r das Spielbrett
    char[] board = new char[9];

    public void printBoard(String[] board) {
        System.out.println(board[7] + " | " + board[8] + " | " + board[9] + " | ");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6] + " | ");
        System.out.println(board[1] + " | " + board[2] + " | " + board[3] + " | ");
    }

    // Teile den gewÃƒÂ¼nschten Buchstaben dem Spieler / Computer zu
    public char[] playerLetter() {
        char letter = ' ';
        char[] arr;
        while (letter != 'x' || letter != 'o') {
            System.out.println("Do you want to be X or O?");
        }
        letter = in.next().toUpperCase().charAt(0);

        if (letter == 'X') {
            return arr = new char[]{'X', 'O'};
        } else {
            return arr = new char[]{'O', 'X'};
        }
    }

    public String whoGoesFirst() {
        int r = randomNumber.nextInt(2);
        System.out.println(r);
        if (r == 0) {
            return "Computer";
        } else {
            return "Player";
        }
    }

    // Setze deine Figur
    public void makeMove(char[] board, char letter, int move) {
        board[move] = letter;
    }

    public boolean isWinner(char[] board, char letter) {
        if (board[7] == letter && board[8] == letter && board[9] == letter) {
            return true;
        } else if (board[4] == letter && board[5] == letter && board[6] == letter) {
            return true;
        } else if (board[1] == letter && board[2] == letter && board[3] == letter) {
            return true;
        } else if (board[7] == letter && board[4] == letter && board[1] == letter) {
            return true;
        } else if (board[8] == letter && board[5] == letter && board[2] == letter) {
            return true;
        } else if (board[9] == letter && board[6] == letter && board[3] == letter) {
            return true;
        } else if (board[7] == letter && board[5] == letter && board[3] == letter) {
            return true;
        } else if (board[9] == letter && board[5] == letter && board[1] == letter) {
            return true;
        } else {
            return false;
        }

    }

    // FÃ¼r die KI, damit sie Ãƒâ€žnderungen an einer temporÃ¤ren Kopie des Spielbretts machen kann, um somit einen Zug zu planen
    public char[] getBoardCopy(char[] board) {
        char[] boardCopy = new char[10];
        for (int i = 0; i < board.length; i++) {
            boardCopy[i] = board[i];
        }
        return boardCopy;
    }
    // Ist auf dem Feld feier Platz vorhanden?
    public boolean isSpaceFree(char[] board, int move) {
        if (board[move] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public int getPlayerMove(char[] board){
        int move = 0;
        // Solange der User keine Korrekte Eingabe zwischen 1 und 9 macht und solange das entsprechende
        // Feld nicht frei ist, frage wo der User setzen will.
        while (move < 1 && move > 9 || isSpaceFree(board, move) != true){
            System.out.println("What is your next move? (1-9)");
        }
        move = in.nextInt();
        return move;
    }
    public void chooseRandomMoveFromList(char[] board, int[] movesList){

    }

}
