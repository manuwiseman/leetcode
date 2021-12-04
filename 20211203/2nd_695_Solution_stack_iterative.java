class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Stack<int[]> stack = new Stack<int[]>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int shape = 0;
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;
                    while(!stack.isEmpty()) {
                        int[] cell = stack.pop();
                        shape++;
                        for (int[] n : neighbors) {
                            int nr = cell[0] + n[0];
                            int nc = cell[1] + n[1];
                            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] == 1) {
                                stack.push(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }    
        return ans;
    }
}