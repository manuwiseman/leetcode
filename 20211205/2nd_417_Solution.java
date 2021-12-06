class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] landHeights;
    int m, n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        landHeights = heights;
        
        boolean[][] atlanticReachable = new boolean[m][n];
        boolean[][] pacificReachable = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, n - 1, atlanticReachable);
        }
        
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacificReachable);
            dfs(m - 1, j, atlanticReachable);
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int i, int j, boolean[][] reachable) {
        reachable[i][j] = true;
        for (int[] dir : directions) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || reachable[nr][nc] || landHeights[i][j] > landHeights[nr][nc]) {
                continue;
            }
            dfs(nr, nc, reachable);
        }
    }
}