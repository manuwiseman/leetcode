class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int[] visited = new int[isConnected.length];
        
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, isConnected, visited);
            }
        }     
        return count;
    }
    
    private void dfs(int i, int[][] isConnected, int[] visited) {
        visited[i] = 1;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(j, isConnected, visited);
            }
        }
    }
}