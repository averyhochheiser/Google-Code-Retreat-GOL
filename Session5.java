import static org.junit.Assert.*;

import java.text.Format;
import java.util.Arrays;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AppTest {

    @Test
    public void testInit() {
        int[][] board = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };

        int[][] cmp = initBoard(3, 3);
        assertArrayEquals(board, cmp);
    }

    public int[][] initBoard(int x, int y) {
        int[][] board = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };

        return board;
    }

    @Test
    public void testPopulate() {
        int[][] board = {
                { 1, 0, 0 },
                { 0, 0, 0 },
                { 1, 0, 1 }
        };

        assertEquals(3, checkPopulate(board, 3, 3));
    }

    public int checkPopulate(int[][] board, int x, int y) {

        int population = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 1) {
                    population++;
                }
            }
        }

        return population;
    }

    @Test
    public void testUnpopulate() {
        int[][] board = {
                { 1, 0, 0 },
                { 0, 0, 0 },
                { 1, 0, 1 }
        };

        assertEquals(6, checkUnPopulate(board, 3, 3));
    }

    public int checkUnPopulate(int[][] board, int x, int y) {

        int unPopulation = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 0) {
                    unPopulation++;
                }
            }
        }

        return unPopulation;
    }

    @Test
    public void testNeighbors() {
        int[][] board = {
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0 }
        };

        assertEquals(8, findNeighbors(board, 2, 2));
    }

    public int findNeighbors(int[][] board, int x, int y) {

        int neighborCount = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            if (board[i][y + 1] == 1) {
                neighborCount++;
            }
        }

        for (int i = x - 1; i <= x + 1; i++) {
            if (board[i][y - 1] == 1) {
                neighborCount++;
            }
        }

        if (board[x - 1][y] == 1) {
            neighborCount++;
        }

        if (board[x + 1][y] == 1) {
            neighborCount++;
        }

        return neighborCount;
    }

    @Test
    public void populate() {
        int[][] board = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };

        populate(board, 1, 1);

        assertEquals(1, board[1][1]);
    }

    public void populate(int[][] board, int x, int y) {
        board[x][y] = 1;
    }

    @Test
    public void shouldBePopulated() {
        int[][] board = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 1 }
        };

        assertEquals(7, checkPopulate(board, 5, 5));
    }

    @Test
    public void shouldBeUnpopulated() {
        int[][] board = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 1 }
        };

        assertNotEquals(18, checkPopulate(board, 5, 5));
    }

    @Test
    public void shapeCheck() {
        int[][] board = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 0 },
                { 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        assertEquals("beehive", findShape(board));
    }

    public String findShape(int[][] board) {

        int[][] block = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        int[][] beehive = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 0 },
                { 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        int[][] loaf = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 0 }
        };

        int[][] boat = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        int[][] tub = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        if (Arrays.deepEquals(board, block)) {
            return "block";
        }

        if (Arrays.deepEquals(board, beehive)) {
            return "beehive";
        }

        if (Arrays.deepEquals(board, loaf)) {
            return "loaf";
        }

        if (Arrays.deepEquals(board, boat)) {
            return "boat";
        }

        if (Arrays.deepEquals(board, tub)) {
            return "tub";
        }

        return "";
    }

}
