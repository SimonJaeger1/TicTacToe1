import java.util.Scanner;

public class TicTacToe {

    Scanner sc = new Scanner(System.in);
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {

        board.clear();

        while (!hasWinner() && !board.isFull()) {
            board.print();
            System.out.println("Current player: " + currentPlayer.getMarker());

            int row = rowInput() -1 ;
            int col = columnInput() - 1;
            while (!board.isCellEmpty(row, col)) {
                System.out.println("Field is already taken!");
                row = rowInput() - 1;
                col = columnInput() - 1;
            }

            board.place(row, col, currentPlayer.getMarker());

            if (hasWinner()) {
                System.out.println("Player " + currentPlayer.getMarker() + " has won!");
            } else if (!hasWinner() && board.isFull()) {
                board.print();
                System.out.println("The game ended in a draw!");
            }

            switchCurrentPlayer();
        }

        newGame();
    }

    public void newGame() {
        System.out.println("New game? [y|n]: ");
        String input = sc.next();
        if (input.equals("y")) {
            start();
        } else if (input.equals("n")) {
            System.out.println("Thanks for playing!");
        } else {
            System.out.println("Not a valid input, must be 'y' or 'n'");
            newGame();
        }
    }

    public int rowInput() {
        System.out.println("row (1-3): ");
        int row = sc.nextInt();
        if (row < 1 || row > 3) {
            System.out.println("Index is out of bounds");
            rowInput();
        }
        return row;
    }

    public int columnInput() {
        System.out.println("column (1-3): ");
        int column = sc.nextInt();
        if (column < 1 || column > 3) {
            System.out.println("Index is out of bounds");
            columnInput();
        }
        return column;
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!board.isCellEmpty(i,0) && board.cells[i][0] == board.cells[i][1] && board.cells[i][1] == board.cells[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (!board.isCellEmpty(0, i) && board.cells[0][i] == board.cells[1][i] && board.cells[1][i] == board.cells[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (!board.isCellEmpty(0, 0) && board.cells[0][0] == board.cells[1][1] && board.cells[1][1] == board.cells[2][2]) {
            return true;
        }
        if (!board.isCellEmpty(0, 2) && board.cells[0][2] == board.cells[1][1] && board.cells[1][1] == board.cells[2][0]) {
            return true;
        }

        return false;
    }
}
