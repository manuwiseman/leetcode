class Solution {
	private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	int[][] landHeights;
	int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        
        landHeights = heights;
        m = heights.length;
        n = heights[0].length;

        Queue<int[]> atlanticQueue = new LinkedList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
        	atlanticQueue.add(new int[]{i, 0});
        	pacificQueue.add(new int[]{i, n - 1});
        }

        for (int i = 0; i < n; i++) {
        	atlanticQueue.add(new int[]{0, i});
        	pacificQueue.add(new int[]{m - 1, i});
        }

        boolean[][] atlanticReachable = bfs(atlanticQueue);
        boolean[][] pacificReachable = bfs(pacificQueue);


        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (atlanticReachable[i][j] && pacificReachable[i][j]) {
        			res.add(List.of(i, j));
        		}
        	}
        }

        return res;
    }

    private boolean[][] bfs(Queue<int[]> queue) {
    	boolean[][] reachable = new boolean[m][n];
    	while(!queue.isEmpty()) {
    		int[] element = queue.poll();
    		reachable[element[0]][element[1]] = true;
    		for (int[] dr : DIRECTIONS) {
    			int newRow = element[0] + dr[0];
    			int newCol = element[1] + dr[1];

    			if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || reachable[newRow][newCol]) {
    				continue;
    			}

    			if (landHeights[element[0]][element[1]] > landHeights[newRow][newCol]) {
    				continue;
    			}

    			queue.add(new int[]{newRow, newCol});
    		}
    	}

    	return reachable;
    }
}