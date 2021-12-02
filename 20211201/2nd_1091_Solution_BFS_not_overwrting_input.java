class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        Queue<int[]> q = new LinkedList<int[]>();
        visited[0][0] = true;
        q.add(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] element = q.poll();
            int row = element[0];
            int col = element[1];
            int distance = element[2];
            
            if (row == n - 1 && col == n - 1) {
                return distance;
            }
            
            for (int[] neighbor : getNeighbors(grid, row, col)) {
                int newRow = neighbor[0];
                int newCol = neighbor[1];
                if (visited[newRow][newCol]) continue;
                visited[newRow][newCol] = true;
                q.add(new int[]{newRow, newCol, distance + 1});
            }
        }
        return -1;
    }
    
    private List<int[]> getNeighbors(int[][] grid, int row, int col) {
        List<int[]> neighbors = new ArrayList<int[]>();
        for (int[] dir : this.directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 0) {
                neighbors.add(new int[]{newRow, newCol});
            }
        }
        return neighbors;
    }
}