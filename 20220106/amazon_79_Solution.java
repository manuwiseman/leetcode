// 1. intuition: since this is checking feasibility in a matrix, I am thinking about DFS
class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] board;
    int m, n;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }
    
    // DFS search the string, this is backtracking (special case of DFS)
    private boolean dfs(int row, int col, int idx, String word) {
        if (idx == word.length() - 1) {
            return true;
        }
        char c = board[row][col];
        board[row][col] = '#';
        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == word.charAt(idx + 1)) {
                if (dfs(nr, nc, idx + 1, word)) return true;
            }
        }
        board[row][col] = c;
        return false;
    }
}