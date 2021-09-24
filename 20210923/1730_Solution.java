class Solution {
    public int getFood(char[][] grid) {
    	int m = grid.length, n = grid[0].length;
    	// adjacent cells
    	int[][] neighbors = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();

        // find the start
        int[] start = getStart(grid);
        int startX = start[0], startY = start[1];
        queue.add(start);
        visited[startX][startY] = true;

        int step = 0;

        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		int[] element  = queue.poll();
        		int x = element[0], y = element[1];
        		if (grid[x][y] == '#') return step;
        		for (int[] neighbor : neighbors) {
        			int dx = x + neighbor[0];
        			int dy = y + neighbor[1];
        			if (isValid(dx, dy, grid) && !visited[dx][dy]) {
        				queue.add(new int[] {dx, dy});
        				visited[dx][dy] = true;
        			}
        		}
        	}
        	step++;
        }
        return -1;
    }

    int[] getStart(char[][] grid) {
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == '*') return new int[] {i, j};
    		}
    	}
    	return new int[] {-1, -1};
    }

    boolean isValid(int x, int y, char[][] grid) {
    	return !(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 'X');
    }
}