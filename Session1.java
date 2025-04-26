public class gameBoard {

    private class cell {
        public boolean populated;
        public cell below;
        public cell above;
        public cell left;
        public cell right;

        public cell(boolean pop, cell cellBelow, cell cellAbove, cell cellLeft, cell cellRight) {
            populated = pop;
            below = cellBelow;
            above = cellAbove;
            left = cellLeft;
            right = cellRight;
        }
    }

    private cell populated;
    private final int dim;

    public gameBoard(int dimension) {
        dim = dimension;
        boolean populated = false;
    }

    public int testNeighbors(int[][] board, int x, int y) {

        int xStart = x - 1;
        int neighbors = 0;

        for (int i = y + 1; i >= y - 1; i--) {
            if (isPopulated(board, xStart, i)) {
                neighbors++;
            }
        }

        xStart += 2;
        for (int i = y + 1; i >= y - 1; i--) {
            if (isPopulated(board, xStart, i)) {
                neighbors++;
            }
        }

        if (isPopulated(board, x, y + 1)) {
            neighbors++;
        }

        if (isPopulated(board, x, y - 1)) {
            neighbors++;
        }

        if (y == 0 && isPopulated(board, x, dim - 1)) {
            neighbors++;
        }

        if (y == dim - 1 && isPopulated(board, x, 0)) {
            neighbors++;
        }

        return neighbors;
    }

    public boolean isPopulated(int[][] board, int x, int y) {
        if (board[x][y] == 1) {
            return true;
        }

        return false;
    }

    public void ruleDecider(int[][] board, int x, int y) {
        int cellNeighbors = testNeighbors(board, x, y);

        if (cellNeighbors == 0 || cellNeighbors == 1) {
            rule01(board, x, y);
        }

        if (cellNeighbors >= 4) {
            rule4(board, x, y);
        }

        if (cellNeighbors == 3 && !isPopulated(board, x, y)) {
            rule3Unpop(board, x, y);
        }
    }

    public void changeStatus(int[][] board, int x, int y) {
        if (isPopulated(board, x, y)) {
            board[x][y] = 0;
        }

        else {
            board[x][y] = 1;
        }
    }

    public void rule01(int[][] board, int x, int y) {
        changeStatus(board, x, y);
    }

    public void rule4(int[][] board, int x, int y) {
        changeStatus(board, x, y);
    }

    public void rule3Unpop(int[][] board, int x, int y) {
        changeStatus(board, x, y);
    }

}
