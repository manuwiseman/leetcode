class Solution {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int numIslands(char[][] grid) {
        //if (grid == null || grid.length == 0) {
        //    return 0;
        //}
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] != '0') {
        			dfs(grid, i, j);
        			res++;
        		}
        	}
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
    	if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
    	for (int[] direction : directions) {
    		dfs(grid, i + direction[0], j + direction[1]);
    	}
    }
}