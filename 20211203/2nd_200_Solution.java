class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        Stack<int[]> stack = new Stack<int[]>();
        int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    stack.push(new int[]{i, j});
                    grid[i][j] = '0';
                    count++;
                    while(!stack.isEmpty()) {
                        int[] cell = stack.pop();
                        for (int[] n : neighbors) {
                            int nr = cell[0] + n[0];
                            int nc = cell[1] + n[1];
                            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                                stack.push(new int[]{nr, nc});
                                grid[nr][nc] = '0';
                            }
                        } 
                    }
                }
            }
        }
        return count;
    }
}