import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void startHasWinnerRowTrue() {
        setUp();
        ticTacToe.board.place(0,0,'X');
        ticTacToe.board.place(0,1,'X');
        ticTacToe.board.place(0,2,'X');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void HasWinnerRowFalse() {
        setUp();
        ticTacToe.board.place(0,0,'O');
        ticTacToe.board.place(0,1,'X');
        ticTacToe.board.place(0,2,'X');
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void HasWinnerColumnTrue() {
        setUp();
        ticTacToe.board.place(0,0,'X');
        ticTacToe.board.place(1,0,'X');
        ticTacToe.board.place(2,0,'X');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void HasWinnerColumnFalse() {
        setUp();
        ticTacToe.board.place(0,0,'O');
        ticTacToe.board.place(1,0,'X');
        ticTacToe.board.place(2,0,'X');
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void HasWinnerDiagonalTrue() {
        setUp();
        ticTacToe.board.place(0,0,'X');
        ticTacToe.board.place(1,1,'X');
        ticTacToe.board.place(2,2,'X');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void HasWinnerDiagonalFalse() {
        setUp();
        ticTacToe.board.place(0,0,'O');
        ticTacToe.board.place(1,1,'X');
        ticTacToe.board.place(2,2,'X');
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void HasWinnerReverseDiagonalTrue() {
        setUp();
        ticTacToe.board.place(0,2,'X');
        ticTacToe.board.place(1,1,'X');
        ticTacToe.board.place(2,0,'X');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void HasWinnerReverseDiagonalFalse() {
        setUp();
        ticTacToe.board.place(0,2,'O');
        ticTacToe.board.place(1,1,'X');
        ticTacToe.board.place(2,0,'X');
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void switchCurrentPlayerTrue() {
        setUp();
        ticTacToe.switchCurrentPlayer();
        assertSame(ticTacToe.currentPlayer, ticTacToe.player2);
    }

    @Test
    void switchCurrentPlayerFalse() {
        setUp();
        ticTacToe.currentPlayer = ticTacToe.player2;
        ticTacToe.switchCurrentPlayer();
        assertNotSame(ticTacToe.currentPlayer, ticTacToe.player2);
    }
}