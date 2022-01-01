class Solution {
    int count, m, n;
    char[][] grid;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(int row, int col) {
        this.grid[row][col] = '0';
        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr >= 0 && nr < this.m && nc >= 0 && nc < this.n && this.grid[nr][nc] == '1') {
                dfs(nr, nc);
            }
        }
    }
}