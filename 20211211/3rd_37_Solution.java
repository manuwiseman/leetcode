class Solution {
    // length of subbox
    int n = 3;
    // length of row & col
    int N = 9;
    // 3 2-d arraies to track row, col, subbox
    int[][] row = new int[N][N + 1];
    int[][] col = new int[N][N + 1];
    int[][] subbox = new int[N][N + 1];
    
    char[][] board;
    
    boolean isSudoku = false;
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0;i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    placeNumber(i, j, Character.getNumericValue(board[i][j]));
                }
            }
        }
        backtracking(0, 0);
    }
    
    private void placeNumber(int i, int j, int d) {
        int idx = (i / n) * n + j / n;
        row[i][d]++;
        col[j][d]++;
        subbox[idx][d]++;
        board[i][j] = (char) ('0' + d);
    }
    
    private void backtracking(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d <= N; d++) {
                if (couldPlaceNumber(row, col, d)) {
                    placeNumber(row, col, d);
                    nextBacktracking(row, col);
                    if (!isSudoku) removeNumber(row, col, d);
                }
            }
        } else {
            nextBacktracking(row, col);
        }
    }
    
    private boolean couldPlaceNumber(int i, int j, int d) {
        return row[i][d] + col[j][d] + subbox[(i / n) * n + j / n][d] == 0;
    }
    
    private void nextBacktracking(int row, int col) {
        if (row == N - 1 && col == N - 1) {
            this.isSudoku = true;
        } else if (col == N - 1) {
            backtracking(row + 1, 0);
        } else {
            backtracking(row, col + 1);
        }
    }
    
    private void removeNumber(int i, int j, int d) {
        int idx = (i / n) * n + j / n;
        row[i][d]--;
        col[j][d]--;
        subbox[idx][d]--;
        board[i][j] = '.';
    }
}