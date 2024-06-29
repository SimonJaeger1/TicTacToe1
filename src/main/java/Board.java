import java.util.Arrays;
import java.util.Scanner;

public class Board {
    char[][] cells;

    public Board() {
        cells = new char[3][3];
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == 0;
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        cells = new char[3][3];
    }

    public void print() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------");
        for (char[] row: cells) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------");
    }
}
