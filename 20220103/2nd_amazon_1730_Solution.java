// 1. shortest path -> BFS problem

class Solution {
    public int getFood(char[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (m <= 1 && n <= 1) return -1;
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // once we find our location, we can start BFS
                if (grid[i][j] == '*') {
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int size = q.size();
                        ans++;
                        while (size-- > 0) {
                            int[] point = q.poll();
                            for (int[] dir : directions) {
                                int nr = point[0] + dir[0];
                                int nc = point[1] + dir[1];
                                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 'X' || grid[nr][nc] == '*') continue;
                                if (grid[nr][nc] == '#') return ans; 
                                if (grid[nr][nc] == 'O') {
                                    q.add(new int[]{nr, nc});
                                    grid[nr][nc] = 'X';
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}