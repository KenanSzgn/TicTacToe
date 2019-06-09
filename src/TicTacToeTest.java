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
        char[] playerLetterArray = new char[2];
        char[] computerLetterArray = new char[2];
        char playerLetterChar = ' ';
        char computerLetterChar = ' ';
        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean hilfe = true;
        while (hilfe) {
            // setze das Spielbrett zurück
            char[] theBoard = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
            // QUESTION:
            // in Python you can use multiple assigments and
            // it looks like this: playerLetterArray, computerLetterArray = inputPlayerLetter()
            // i need a alternative solution for java
            // wie greift man auf die einzelnen chars von einem array zu und übergibt sie jeweils verschiedenen Variablen
            playerLetterArray = ob.inputPlayerLetter();
            System.out.println(playerLetterArray[0]+" and "+playerLetterArray[1]);
            playerLetterChar = playerLetterArray[0];
            computerLetterChar = playerLetterArray[1];

            String turn = ob.whoGoesFirst();
            System.out.println("The " + turn + " will go first.");

            boolean gameIsPlaying = true;
            while (gameIsPlaying) {
                // The turn of the Player
                if (turn == "Player") {
                    // Prints a clean board
                    ob.printBoard(theBoard);
                    int move = ob.getPlayerMove(theBoard);
                    ob.makeMove(theBoard, playerLetterChar, move);

                    if (ob.isWinner(theBoard, playerLetterChar) == true) {
                        ob.printBoard(theBoard);
                        gameIsPlaying = false;
                        System.out.println("Hooray! You have won the game!");
                    } else if (ob.isBoardFull(theBoard) == true) {
                            System.out.println("The game is a tiel!");
                            break;
                        } else {
                            turn = "Computer";
                        }
                    } else {
                    // The turn of the Computers
                    int move = ob.getComputerMove(theBoard, computerLetterChar);
                    ob.makeMove(theBoard, computerLetterChar, move);

                    if (ob.isWinner(theBoard, computerLetterChar) == true) {
                        ob.printBoard(theBoard);
                        System.out.println("The Computer has beaten you! You lose.");
                        gameIsPlaying = false;
                    } else if (ob.isBoardFull(theBoard) == true) {
                            System.out.println("The game is a tiel!");
                            break;
                        } else {
                            turn = "Player";
                        }
                    }
                }
            }

    }
}
