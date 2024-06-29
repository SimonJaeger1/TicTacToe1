import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolboxTest {

    @Test
    void generateField() {
        char[][] expectedField = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        char[][] generatedField = Toolbox.generateField();
        assertArrayEquals(expectedField, generatedField);
    }

    @Test
    void testGenerateFieldNotNull() {
        assertNotNull(Toolbox.generateField());
    }

    @Test
    void testCheckWinner_NoWinnerAtStart() {
        assertFalse(Toolbox.checkWinner());
    }

    @Test
    void testCheckWinner_NoWinner() {
        char[][] playfield = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'O'}
        };
        Toolbox.playfield = playfield;
        Toolbox.playerTurn = 'X';
        assertFalse(Toolbox.checkWinner());
    }

    @Test
    void testCheckWinner_RowWin() {
        char[][] playfield = {
                {'X', 'X', 'X'},
                {'O', '-', 'O'},
                {'-', 'O', '-'}
        };
        Toolbox.playfield = playfield;
        Toolbox.playerTurn = 'X';
        assertTrue(Toolbox.checkWinner());
    }

    @Test
    void testCheckWinner_ColumnWin() {
        char[][] playfield = {
                {'X', 'O', '-'},
                {'X', 'O', '-'},
                {'X', '-', 'O'}
        };
        Toolbox.playfield = playfield;
        Toolbox.playerTurn = 'X';
        assertTrue(Toolbox.checkWinner());
    }

    @Test
    void testCheckWinner_DiagonalWin() {
        char[][] playfield = {
                {'X', 'O', 'O'},
                {'-', 'X', '-'},
                {'O', '-', 'X'}
        };
        Toolbox.playfield = playfield;
        Toolbox.playerTurn = 'X';
        assertTrue(Toolbox.checkWinner());
    }

    @Test
    void testCheckWinner_ReverseDiagonalWin() {
        char[][] playfield = {
                {'O', 'O', 'X'},
                {'-', 'X', '-'},
                {'X', '-', 'O'}
        };
        Toolbox.playfield = playfield;
        Toolbox.playerTurn = 'X';
        assertTrue(Toolbox.checkWinner());
    }

    @Test
    void testRequestGame_Continue() {
        // Simulate user input "y" for continue
        Toolbox.keepPlaying = "y";
        Toolbox.requestGame();
        assertFalse(Toolbox.gameWon);
        assertEquals(0, Toolbox.turnCounter);
        assertEquals('X', Toolbox.playerTurn);
        assertEquals('-', Toolbox.playfield[0][0]);
    }
    



    @Test
    void printArray() {
    }

    @Test
    void start() {
    }
}