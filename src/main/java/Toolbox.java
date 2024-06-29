import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Toolbox {

    static char playerTurn = 'X';
    static boolean gameWon = false;
    static char[][] playfield = generateField();
    static String keepPlaying;
    static String row;
    static String column;
    static BufferedReader re;
    static int turnCounter = 0;

    static char[][] generateField() {
        char[][] f1 = new char[3][3];
        for (char[] chars : f1) {
            Arrays.fill(chars, '-');
        }
        return f1;
    }

    static void printArray() {
        for (char[] chars : playfield) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    static void start() {
        while (!gameWon) {
            System.out.println("Current player turn: " + playerTurn);
            System.out.print("Input row (0-2): ");
            re = new BufferedReader(new InputStreamReader(System.in));
            try {
                row = re.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.print("Input column (0-2): ");
            re = new BufferedReader(new InputStreamReader(System.in));
            try {
                column = re.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            int rowInt = Integer.parseInt(row);
            int rowCol = Integer.parseInt(column);

            // Check input validity
            if (rowInt > -1 && rowInt < 3 && rowCol > -1 && rowCol < 3) {
                if (playfield[rowInt][rowCol] == '-') {
                    playfield[rowInt][rowCol] = playerTurn;
                    turnCounter++;
                } else {
                    System.out.println("Field has already been played, please try again");
                    start();
                }

                printArray();

                gameWon = checkWinner();
                if (gameWon) {
                    System.out.println("Player " + playerTurn + " has won");
                    requestGame();
                } else if (!gameWon && turnCounter == 9){
                    System.out.println("The game has ended in a draw");
                    requestGame();
                    break;
                }

                if (!gameWon) {
                    if (playerTurn == 'X') {
                        playerTurn = 'O';
                    } else playerTurn = 'X';
                }
            } else{
                System.out.println("Invalid input for player " + playerTurn);
            }
        }
    }

    static boolean checkWinner() {
        for (char[] chars : playfield) {
            if (chars[0] == playerTurn && chars[1] == playerTurn && chars[2] == playerTurn) {
                return true;
            }
        }
        if ((playfield[0][0] == playerTurn && playfield[1][1] == playerTurn && playfield[2][2] == playerTurn) ||
                (playfield[2][0] == playerTurn && playfield[1][1] == playerTurn && playfield[0][2] == playerTurn)) {
            return true;
        }
        return (playfield[0][0] == playerTurn && playfield[1][0] == playerTurn && playfield[2][0] == playerTurn) ||
                (playfield[0][1] == playerTurn && playfield[1][1] == playerTurn && playfield[2][1] == playerTurn) ||
                (playfield[0][2] == playerTurn && playfield[1][2] == playerTurn && playfield[2][2] == playerTurn);
    }

    static void requestGame() {
        System.out.println("Continue?");
        try {
            keepPlaying = re.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (Objects.equals(keepPlaying, "y")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            playfield = generateField();
            gameWon = false;
            turnCounter = 0;
            playerTurn = 'X';
            printArray();
            start();
        } else if (Objects.equals(keepPlaying, "n")){
            System.out.println("Thank you for playing");
        } else {
            System.out.println("Invalid input");
            requestGame();
        }
    }
}