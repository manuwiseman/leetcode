class Solution {
    // length of subbox
    int n = 3;
    // length of row and col
    int N = 9;
    char[][] board;
    boolean isSudoku = false;
    
    int[][] rows = new int[N][N + 1];
    int[][] cols = new int[N][N + 1];
    int[][] subboxes = new int[N][N + 1];
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        // populate rows, cols, subboxes with existing values
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    placeNumber(i, j , Character.getNumericValue(board[i][j]));
                }
            } 
        }
        // backtracking to fill the empty cells
        backtracking(0, 0);
    }
    
    private void placeNumber(int i, int j, int d) {
        int idx = (i / n) * n + j / n;
        rows[i][d]++;
        cols[j][d]++;
        subboxes[idx][d]++;
        board[i][j] = (char) (d + '0');
    }
    
    private void backtracking(int i, int j) {
        if (board[i][j] == '.') {
            for (int d = 1; d <= N; d++) {
                if (couldPlaceNumber(i, j, d)) {
                    placeNumber(i, j, d);
                    placeNextNumber(i, j);
                    if (!isSudoku) removeNumber(i, j, d); 
                }
            }
        } else {
            placeNextNumber(i, j);
        }
    }
    
    private boolean couldPlaceNumber(int i, int j, int d) {
        return rows[i][d] + cols[j][d] + subboxes[(i / n) * n + j / n][d] == 0;
    }
    
    private void placeNextNumber(int i, int j) {
        if (i == N - 1 && j == N - 1) {
            isSudoku = true;
        } else if (j == N - 1) {
            backtracking(i + 1, 0);
        } else {
            backtracking(i, j + 1);
        }
    }
    
    private void removeNumber(int i, int j, int d) {
        int idx = (i / n) * n + j / n;
        rows[i][d]--;
        cols[j][d]--;
        subboxes[idx][d]--;
        board[i][j] = '.';
    }
}