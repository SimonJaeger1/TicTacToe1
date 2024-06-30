import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    void setUp() {
        board = new Board();
    }

    @Test
    void testIsCellEmptyYes() {
        setUp();
        assertTrue(board.isCellEmpty(0,0));
    }

    @Test
    void testIsCellEmptyNo() {
        setUp();
        board.place(0,0,'O');
        assertFalse(board.isCellEmpty(0,0));
    }

    @Test
    void testPlaceTrue() {
        setUp();
        board.place(0,0, 'O');
        assertEquals('O', board.cells[0][0]);
    }

    @Test
    void testPlaceFalse() {
        setUp();
        board.place(0,0, 'O');
        assertNotEquals('X', board.cells[0][0]);
    }

    @Test
    void isFullTrue() {
        setUp();
        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                board.place(i, j, 'O');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void isFullFalse() {
        setUp();
        board.place(0,0, 'X');
        board.place(1,1, 'O');
        assertFalse(board.isFull());
    }

    @Test
    void clear() {
        setUp();
        board.place(0,0, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0,0));
    }

}