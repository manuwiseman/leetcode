class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    char[][] board;
    
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (backtracking(0, word, i, j, new boolean[this.m][this.n])) return true;
            }
        }
        
        return false;
    }
    
    private boolean backtracking(int count, String word, int i, int j, boolean[][] visited) {
        if (count == word.length()) return true;
        char c = word.charAt(0);
        if (i < 0 || i >= this.m || j < 0 || j >= this.n || this.board[i][j] != word.charAt(count)|| visited[i][j]) return false;
        
        visited[i][j] = true;
        
        for (int[] dr : this.DIRECTIONS) {           
            if (backtracking(count + 1, word, i + dr[0], j + dr[1], visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}