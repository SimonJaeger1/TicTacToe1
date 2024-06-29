import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    void newBoard() {
        board = new Board();
    }

    @Test
    void testIsCellEmptyYes() {
        newBoard();
        assertTrue(board.isCellEmpty(0,0));
    }

    @Test
    void testIsCellEmptyNo() {
        newBoard();
        board.place(0,0,'O');
        assertFalse(board.isCellEmpty(0,0));
    }

    @Test
    void testPlaceTrue() {
        newBoard();
        board.place(0,0, 'O');
        assertEquals('O', board.cells[0][0]);
    }

    @Test
    void testPlaceFalse() {
        newBoard();
        board.place(0,0, 'O');
        assertNotEquals('X', board.cells[0][0]);
    }

    @Test
    void isFullTrue() {
        newBoard();
        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                board.place(i, j, 'O');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void isFullFalse() {
        newBoard();
        board.place(0,0, 'X');
        board.place(1,1, 'O');
        assertFalse(board.isFull());
    }

    @Test
    void clear() {
        newBoard();
        board.place(0,0, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0,0));
    }

    /*@Test
    void print() {
        newBoard();
        board.print();

        String expectedOutput =
                "---------\n" +
                "[ , , ]\n" +
                "[ , , ]\n" +
                "[ , , ]\n" +
                "---------\n";
        assertEquals(expectedOutput, board.toString());
    }*/
}