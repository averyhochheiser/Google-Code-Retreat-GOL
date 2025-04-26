import static org.junit.Assert.*;

import java.text.Format;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AppTest {
    public static int isPop = 0;

    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public static boolean isPopulated(int[][] board, int x, int y) {

        if (board[x][y] == 1) {
            return true;
        }

        return false;

    }

    public static int findNeighbors(int[][] board, int x, int y) {

        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i != 1 || j != 1) && board[i][j] == 1) {
                    count++;
                }

            }
        }

        return count;
    }

    int[][] buildBoard() {
        int[][] board = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = 0;
            }
        }
        return board;

    }

    @Test
    public void testIsPopulatedTest() {
        int[][] board = buildBoard();
        board[4][5] = 1;

        assertEquals(true, isPopulated(board, 4, 5));

    }

    @Test
    public void testIsPopulated() {
        int[][] board = buildBoard();
        assertFalse(isPopulated(board, 4, 5));
        board[4][5] = 1;
        assertTrue(isPopulated(board, 4, 5));
    }

    @Test
    public void testIsPopulatedRandom() {
        int[][] board = buildBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < 10; k++) {
                    if (Math.random() < 0.5) {
                        board[i][j] = 1;
                        assertTrue(isPopulated(board, i, j));
                        board[i][j] = 0;
                    } else {
                        assertFalse(isPopulated(board, i, j));
                    }
                }
            }
        }
        assertFalse(isPopulated(board, 4, 5));
        board[4][5] = 1;
        assertTrue(isPopulated(board, 4, 5));
    }

    @Test
    public void testNeighborsComplex() {
        for (int n = 0; n < 512; n++) {
            int[][] board = {
                    { 0, 0, 0 },
                    { 0, 0, 0 },
                    { 0, 0, 0 },
            };
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int k = i * 3 + j;
                    board[i][j] = (n >> k) & 1;
                }
            }
            int result = Integer.bitCount(n & ~16);
            String message = String.format("For number: %d", n);

            assertEquals(message, result, findNeighbors(board, 1, 1));
        }
    }

    @Test
    public void testNeighbors() {
        int[][] board = buildBoard();

        board[0][0] = 1;
        board[0][1] = 1;

        assertEquals(2, findNeighbors(board, 1, 1));
    }

    @Test
    public void testNextGenerationSquare() {
        int[][] board = {
                { 0, 0, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        int[][] result = nextGeneration(board);
        assertArrayEquals("The two boards should be equal", board, result);
    }

    @Test
    public void testNextGenerationLine() {
        int[][] board = {
                { 0, 0, 0 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };

        int[][] expected = {
                { 0, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 0 }
        };

        int[][] actual = nextGeneration(board);
        assertArrayEquals(expected, actual);
    }

    public int[][] nextGeneration(int[][] board) {

        return board;
    }
}
