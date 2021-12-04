class Solution {
    int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] grid;
    public int numIslands(char[][] grid) {
        int count = 0;
        this.grid = grid;
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                if (this.grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j) {
        if (i < 0 || i >= this.grid.length || j < 0 || j >= this.grid[0].length || this.grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] n : this.neighbors) {
            dfs(i + n[0], j + n[1]);
        }
    }
}