class Solution {
	private static final int[][] directions = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;

        Queue<int[]> q = new LinkedList<>();

        grid[0][0] = 1;
        q.add(new int[] {0, 0});

        while (!q.isEmpty()) {
        	int[] cell = q.remove();
        	int row = cell[0];
        	int col = cell[1];
        	int distance = grid[row][col];
        	if (row == grid.length - 1 && col == grid[0].length - 1) {
        		return distance;
        	}

        	for (int[] neighbor : getNeighbors(grid, row, col)) {
        		int neighborRow = neighbor[0];
        		int neighborCol = neighbor[1];
        		grid[neighborRow][neighborCol] = distance + 1;
        		q.add(new int[]{neighborRow, neighborCol});
        	}
        }
        return -1;
    }

    private List<int[]> getNeighbors(int[][] grid, int row, int col) {
    	List<int[]> list = new ArrayList<int[]>();
    	for (int i = 0; i < directions.length; i++) {
    		int neighborRow = row + directions[i][0];
    		int neighborCol = col + directions[i][1];
    		if (neighborRow < 0 || neighborRow >= grid.length ||
    			neighborCol < 0 || neighborCol >= grid[0].length ||
    			grid[neighborRow][neighborCol] != 0) {
    			continue;
    		}
    		list.add(new int[]{neighborRow, neighborCol});
    	}
    	return list;
    }
}