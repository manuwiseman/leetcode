class Solution {
    int[][] grid;
    int n;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int largestIsland(int[][] grid) {
        // 1. dfs to get the area of each island (grid as-id), and store area for each island into an array
        int max = 0;
        this.grid = grid;
        this.n = grid.length;
        int[] area = new int[n * n + 2];
        int idx = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area[idx] = dfs(i, j, idx++);
                }
            }
        }
        for (int x : area) max = Math.max(max, x);
        
        // 2. flip each of the remaining 0s into 1, and see how many island it can be adjacent to, if so then add the area of that island in the total area for this 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int ans = 1;
                    Set<Integer> set = new HashSet<Integer>();
                    for (int[] dir : getNeighbors(i, j)) {
                        if (grid[dir[0]][dir[1]] > 1) {
                            set.add(grid[dir[0]][dir[1]]);
                        }
                    }
                    for (int x : set) ans += area[x];
                    max = Math.max(max, ans);
                }
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, int idx) {
        int ans = 1;
        grid[i][j] = idx;
        for (int[] dir : getNeighbors(i, j)) {
            if (grid[dir[0]][dir[1]] == 1) {
                grid[dir[0]][dir[1]] = idx;
                ans += dfs(dir[0], dir[1], idx);
            }
        }
        return ans;
    }
    
    // horizontal and vertical adjacent cells that's still in the grid
    private List<int[]> getNeighbors(int i, int j) {
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] dir : directions) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) ans.add(new int[]{nr, nc});
        }
        return ans;
    }
}