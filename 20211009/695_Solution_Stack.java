class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] neighbor = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1 && !visited[i][j]) {
        			Stack<int[]> stack = new Stack<int[]>();
        			int shape = 0;
        			stack.push(new int[]{i, j});
        			visited[i][j] = true;

        			while (!stack.isEmpty()) {
        				int[] node = stack.pop();
        				shape++;
        				for (int x = 0; x < neighbor.length; x++) {
        					int nr = node[0] + neighbor[x][0];
        					int nc = node[1] + neighbor[x][1];
        					if (nr >= 0 && nr <grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 && !visited[nr][nc]) {
        						visited[nr][nc] = true;
        						stack.push(new int[]{nr, nc});
        					}
        				}
        			}
        			res = Math.max(res, shape);
        		}
        	}
        }

        return res;
    }
}