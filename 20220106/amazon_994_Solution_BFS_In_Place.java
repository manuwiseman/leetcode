class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] grid;
    int m, n;
    public int orangesRotting(int[][] grid) {
        // technically of course it starts at 0
        // we make it 2 for now because we want to find the matching value in matrix to process
        int timestamp = 2;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        // as timestamp increments, more oranges rotten
        while (moreOrangesToProcess(timestamp)) {
            timestamp++;
        }
        
        // loop thru the whole grid to see if there's still fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        
        return timestamp - 2;
    }
    
    // mark the fresh orange the timestamp it will rotten
    private boolean moreOrangesToProcess(int timestamp) {
        boolean toBeContinued = false;
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == timestamp) {
                    for (int[] dir : directions) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            grid[nr][nc] = timestamp + 1;
                            toBeContinued = true;
                        }
                    }
                }
            }
        }
        return toBeContinued;
    }
}