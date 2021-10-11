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

        boolean[][] atlanticReachable = new boolean[m][n];
        boolean[][] pacificReachable = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, atlanticReachable);
            dfs(i, n - 1, pacificReachable);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, atlanticReachable);
            dfs(m - 1, i, pacificReachable);
        }

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

    private void dfs(int i, int j, boolean[][] reachable) {
        reachable[i][j] = true;

        for (int[] dr : DIRECTIONS) {
            int newRow = i + dr[0];
            int newCol = j + dr[1];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || reachable[newRow][newCol]) continue;
            if (landHeights[i][j] > landHeights[newRow][newCol]) continue;
            dfs(newRow, newCol, reachable);
        }
    }
}