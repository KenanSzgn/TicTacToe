/**
 * Projektname:            Tic Tac Toe
 * Programmname:
 * Version: 				1.0
 * Erstellungsdatum:		28.05.2019
 * Autor:   				Kenan Sezgin
 **/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner in = new Scanner(System.in);
    Random randomNumber = new Random();
    // Array fÃƒÂ¼r das Spielbrett
    char[] board = new char[9];

    // Diese Methode gibt ihr das übergebene Spielbrett aus
    // board ist ein Array aus 10 Strings (Index 0 wird ignoriert)
    public void printBoard(String[] board) {
        System.out.println(board[7] + " | " + board[8] + " | " + board[9] + " | ");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6] + " | ");
        System.out.println(board[1] + " | " + board[2] + " | " + board[3] + " | ");
    }

    // Lässt den Spieler den gewünschten Buchstaben wählen.
    // Gibt eine Liste mit dem Spielerbuchstaben als erstem und
    // dem Computerbuchstaben als zweitem Element zurück
    public char[] inputPlayerLetter() {
        char letter = ' ';
        char[] arr;
        while (letter != 'x' || letter != 'o') {
            System.out.println("Do you want to be X or O?");
        }
        letter = in.next().toUpperCase().charAt(0);
        // Das erste Element der Liste ist der Buchstabe des Spielers, das
        // zweite der Buchstabede des Computers.
        if (letter == 'X') {
            return arr = new char[]{'X', 'O'};
        } else {
            return arr = new char[]{'O', 'X'};
        }
    }

    // Wählt zufällig aus wer den ersten Zug hat
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

    // Die Methode nimmt ein Spielbrett und den Spielerbuchstaben entgegen und
    // gibt true zurück, wenn der Spieler gewonnen hat.
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

    // Für die KI, damit sie Änderungen an einer temporären Kopie des Spielbretts
    // machen kann, um somit einen Zug zu planen
    // Kopiert die Spielbrettliste und gibt die Kopie zurück
    public char[] getBoardCopy(char[] board) {
        char[] boardCopy = new char[10];
        for (int i = 0; i < board.length; i++) {
            boardCopy[i] = board[i];
        }
        return boardCopy;
    }

    // Gibt true zurück, wenn der übergebene Zug auf dem übergebenen
    // Spielbrett möglich ist
    public boolean isSpaceFree(char[] board, int move) {
        if (board[move] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    // Lässt den Spieler einen Zug eingeben
    public int getPlayerMove(char[] board) {
        int move = 0;
        // Solange der User keine Korrekte Eingabe zwischen 1 und 9 macht und solange das entsprechende
        // Feld nicht frei ist, frage wo der User setzen will.
        while (move < 1 && move > 9 || isSpaceFree(board, move) != true) {
            System.out.println("What is your next move? (1-9)");
        }
        move = in.nextInt();
        return move;
    }

    // Gibt einen gültigen Zug von der übergebenen Liste
    // auf dem übergebenen Spielbrett zurück
    // Gibt null zurück, wenn es keinen gültigen Zug gibt
    public Integer chooseRandomMoveFromList(char[] board, int[] movesList) {
        ArrayList<Integer> possibleMoves = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < movesList.length; i++) {
            if (isSpaceFree(board, i) == true) {
                possibleMoves.add(movesList[i]);
            }
        }
        // Falls die Liste leer ist, gebe einen zufälligen index heraus
        if (possibleMoves.size() != 0) {
            return possibleMoves.get(rand.nextInt(possibleMoves.size()));
        }
        return null;
    }

    public int getComputerMove(char[] board, char computerLetter) {
        char playerLetter;
        if (computerLetter == 'X') {
            playerLetter = 'O';
        } else {
            playerLetter = 'X';
        }
        // Algorithmus für die Tic Tac Toe KI
        // Prüft als erstes ob ein Sieg mit dem nächsten Zug möglich ist
        char[] boardCopy = new char[10];
        for (int i = 0; i < 10; i++){
            boardCopy = getBoardCopy(board);
            if (isSpaceFree(boardCopy, i) == true){
                makeMove(boardCopy, computerLetter, i);
                if (isWinner(boardCopy, computerLetter) == true){
                    return i;
                }
            }
        }

        // Prüft, ob der Spiler mit seinem nächsten Zug gewinnen könnte
        // und blockiert diesen Zug

        for (int i = 0; i < 10; i++){
            boardCopy = getBoardCopy(board);
            if (isSpaceFree(boardCopy, i) == true){
                makeMove(boardCopy, playerLetter, i);
                if (isWinner(boardCopy, playerLetter) == true){
                    return i;
                }
            }
        }

        // Versucht eine der Ecken zu belegen wenn eine frei ist
        Integer move = chooseRandomMoveFromList(board, new int[]{1, 3, 7, 9});
        if (move != null){
            return move;
        }

        // Versucht die Mitte zu belegen, wenn sie frei ist
        if (isSpaceFree(board, 5) == true){
            return 5;
        }

        // Macht einen Zug auf einer der Seiten
        return chooseRandomMoveFromList(board, new int[]{2, 4, 6, 8});
    }

    // Gibt true zurück, wenn alle Spielfelder belegt sind, andernfalls false.
    public boolean isBoardFull(char[] board){
        for (int i = 0; i < 10; i++){
            if (isSpaceFree(board, i) == true){
                return false;
            }
        }
        return true;
    }
}










