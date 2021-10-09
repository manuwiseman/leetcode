class Solution {
    public int numIslands(char[][] grid) {
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue =  new LinkedList<>();
        int res = 0;

        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '1') {
        			queue.add(new int[]{i, j});
                    res++;
        		}

        		while (!queue.isEmpty()) {
        			int[] element = queue.poll();

        			for (int[] dr : directions) {
        				int row = element[0] + dr[0];
        				int col = element[1] + dr[1];
                        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') continue;
                        queue.add(new int[]{row, col});
                        grid[row][col] = '0';
        			}
        		}
        	}
        }

        return res;
    }
}