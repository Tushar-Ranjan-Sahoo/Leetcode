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
