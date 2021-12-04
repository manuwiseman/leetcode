class Solution {
    int[][] grid;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(maxArea, getArea(i, j));
            }
        }
        
        return maxArea;
    }
    
    private int getArea(int i, int j) {
        if (i < 0 || i >= this.grid.length || j < 0 || j >= this.grid[0].length || this.grid[i][j] == 0 || this.visited[i][j] ) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + getArea(i + 1, j) + getArea(i - 1, j) + getArea(i, j + 1) + getArea(i, j - 1);
    }
}