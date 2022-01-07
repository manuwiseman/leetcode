// 1. thoughts: 1. this is a BFS problem cuz it's trying to find the shortest path(min time elapse), but in this question we have to start from potentially multiple cells cuz there might be multiple rotten oranges we start with
// 2. how to tell if there's still fresh orange in the end is the hard part, I use a counter
class Solution {
    
    public int orangesRotting(int[][] grid) {
        // 1. loop thru the whole grid and add all rotten oranges into queue
        int freshCount = 0, m = grid.length, n = grid[0].length;
        int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // count the fresh oranges we start with
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                // insert rotten oranges we start with into q for BFS
                else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        // if we start with no fresh oranges at all, just return 0 
        if (freshCount == 0) return 0;
        
        // 2. BFS processing
        int minute = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            minute++;
            while (size-- > 0) {
                int[] rotten = q.poll();
                for (int[] nei : neighbors) {
                    int nr = rotten[0] + nei[0];
                    int nc = rotten[1] + nei[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        q.add(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        freshCount--;
                        if (freshCount == 0) {
                            return minute;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}