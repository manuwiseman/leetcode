class Solution {
    // length of sub-box
    int n = 3;
    // number of rows/cols
    int N = 9;

    boolean isSudoku = false;
    char[][] board;

    // define row, col, subbox to track whether the number has appeared
    int[][] row = new int[N][N + 1];
    int[][] col = new int[N][N + 1];
    int[][] subbox = new int[N][N + 1];


    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            if (board[i][j] != '.') {
              int d = Character.getNumericValue(board[i][j]);
              placeNumber(i, j, d);
            }
          }
        }
        backtracking(0, 0);
    }

    // method to mark number has appear in row, col, subbox
    private void placeNumber(int i, int j, int d) {
        int index = (i / n) * n + j / n;
        row[i][d]++;
        col[j][d]++;
        subbox[index][d]++;
        board[i][j] = (char) ('0' + d);
    }

    private boolean couldPlaceNumber(int row, int col, int d) {
      int index = (row / 3) * 3 + col / 3;
      return this.row[row][d] + this.col[col][d] + this.subbox[index][d] == 0;
    }

    private void placeNextNumbers(int row, int col) {
      if ((row == N - 1) && (col == N - 1)) {
          this.isSudoku = true;
      } else {
          if (col == N - 1) backtracking(row + 1, 0);
          else backtracking(row, col + 1);
      }
    } 

    private void removeNumber(int i, int j, int d) {
        int index = i / n * n + j / n;
        row[i][d]--;
        col[j][d]--;
        subbox[index][d]--;
        this.board[i][j] = '.';
    }

    private void backtracking(int row, int col){
        if (this.board[row][col] == '.') {
            for (int d = 1; d <= N; d++) {
                if (couldPlaceNumber(row, col, d)) {
                    placeNumber(row, col, d);
                    placeNextNumbers(row, col);
                    if (!isSudoku) removeNumber(row, col, d);
                }
            }
        }
        else placeNextNumbers(row, col);
    }
}