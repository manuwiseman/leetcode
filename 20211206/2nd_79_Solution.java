class Solution {
    char[][] board;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(0, i, j, word, new boolean[m][n])) return true;
            }
        }
        
        return false;
    }
    
    private boolean backtracking(int count, int i, int j, String word, boolean[][] visited) {
        if (count == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || this.board[i][j] != word.charAt(count) || visited[i][j]) return false;    
        
        visited[i][j] = true;
        
        for (int[] dir : directions) {
            if (backtracking(count + 1, i + dir[0], j + dir[1], word, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}