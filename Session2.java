public class gameBoard {

    public int[][] grid;
    public int[][] tempGrid;
    public int numRows;
    public int numCols;

    public gameBoard(int x, int y) {
        grid = new int[x][y];

        numRows = x;
        numCols = y;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void iterate() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int cellNeighbors = countNeighbors(i, j);
                tempGrid[i][j] = checkRule(i, j, cellNeighbors);
            }
        }

        grid = tempGrid;
        System.out.println(grid);
    }

    public int countNeighbors(int x, int y) {
        int neighbors = 0;

        neighbors += neighborsAbove(x, y) + neighborsBelow(x, y) + neighborsSide(x, y);
        return neighbors;
    }

    public int neighborsAbove(int x, int y) {
        int count = 0;

        for (int i = y - 1; i <= y + 1; i++) {
            if (checkXBounds(x) && checkYBounds(y)) {
                if (this.grid[x - 1][i] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public int neighborsBelow(int x, int y) {
        int count = 0;

        for (int i = y - 1; i <= y + 1; i++) {
            if (checkXBounds(x) && checkYBounds(y)) {
                if (this.grid[x + 1][i] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public int neighborsSide(int x, int y) {
        int count = 0;

        if (y >= 0) {
            if (this.grid[x][y - 1] == 1) {
                count++;
            }
        }

        if (y < numCols - 1) {
            if (this.grid[x][y + 1] == 1) {
                count++;
            }
        }

        return count;
    }

    public int checkRule(int x, int y, int cellNeighbors) {

        if (this.grid[x][y] == 1) {
            if ((cellNeighbors == 0 || cellNeighbors == 1) || (cellNeighbors >= 4)) {
                return 0;
            }

            if (cellNeighbors == 2 || cellNeighbors == 3) {
                return 1;
            }

        }

        else {
            if (cellNeighbors == 3) {
                return 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        gameBoard board = new gameBoard(10, 10);
        for (int i = 0; i < 5; i++) {
            board.iterate();
        }
    }

    public boolean checkXBounds(int x) {
        if (x == 0 || x < this.numRows - 1) {
            return false;
        }

        return true;
    }

    public boolean checkYBounds(int y) {
        if (y == 0 || y >= this.numCols) {
            return false;
        }

        return true;
    }

}S