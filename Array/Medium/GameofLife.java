//289. Game of Life
//        Medium
//        5.7K
//        495
//        Companies
//        According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
//        The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//        Any live cell with fewer than two live neighbors dies as if caused by under-population.
//        Any live cell with two or three live neighbors lives on to the next generation.
//        Any live cell with more than three live neighbors dies, as if by over-population.
//        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//        The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
//
//
//
//        Example 1:
//
//
//        Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//        Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
//        Example 2:
//
//
//        Input: board = [[1,1],[1,0]]
//        Output: [[1,1],[1,1]]
//
//
//        Constraints:
//
//        m == board.length
//        n == board[i].length
//        1 <= m, n <= 25
//        board[i][j] is 0 or 1.
public class GameofLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] nextBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextBoard[i][j] = 0;
                    } else {
                        nextBoard[i][j] = 1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextBoard[i][j] = 1;
                    } else {
                        nextBoard[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < m && j >= 0 && j < n && !(i == row && j == col)) {
                    count += board[i][j];
                }
            }
        }

        return count;
    }

}
//    The gameOfLife method takes in a 2D array of integers called board representing the current state of the game. The method updates the board array in place to represent the next state of the game according to the four rules of the Game of Life.
//
//        First, the method gets the dimensions of the board array and creates a new 2D array called nextBoard with the same dimensions. This new array will be used to store the next state of the game.
//
//        Next, the method iterates over each cell in the board array using a nested for loop. For each cell, it calls the countLiveNeighbors method to count the number of live neighbors that cell has.
//
//        If the current cell is alive (represented by a 1 in the board array), then it applies the first three rules of the Game of Life:
//
//        If the cell has fewer than two live neighbors, it dies (represented by a 0 in the nextBoard array).
//        If the cell has two or three live neighbors, it lives on to the next generation (represented by a 1 in the nextBoard array).
//        If the cell has more than three live neighbors, it dies (represented by a 0 in the nextBoard array).
//        If the current cell is dead (represented by a 0 in the board array), then it applies the fourth rule of the Game of Life: 4. If a dead cell has exactly three live neighbors, it becomes a live cell (represented by a 1 in the nextBoard array).
//
//        After all cells have been processed and their next state has been determined, the method copies the values from nextBoard back to board.
//
//        The countLiveNeighbors method takes in a 2D array called board, and two integers called row and col, representing a specific cell in that board. The method returns an integer representing how many live neighbors that cell has.
//
//        First, it initializes a variable called count to 0. This variable will be used to keep track of how many live neighbors have been found.
//
//        Next, it iterates over all cells that are adjacent to or diagonal from the specified cell using a nested for loop. For each neighboring cell, it checks if that cell is within bounds and if it is not equal to itself. If both conditions are met, then it adds its value to count. Since live cells are represented by 1s and dead cells are represented by 0s, this effectively counts how many live neighbors there are.
//
//        Finally, it returns count.
//
//        I hope this explanation helps you understand how this implementation of Game of Life works!
