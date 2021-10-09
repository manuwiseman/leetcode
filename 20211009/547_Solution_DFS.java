class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int res = 0;

        for (int i = 0; i < isConnected.length; i++) {
        	if (visited[i] == 0) {
        		dfs(visited, isConnected, i);
        		res++;
        	}
        }

        return res;
    }

    private void dfs(int[] visited, int[][] isConnected, int i) {
    	visited[i] = 1;
    	for (int j = 0; j < isConnected[i].length; j++) {
    		if (isConnected[i][j] == 1 && visited[j] == 0) {
    			dfs(visited, isConnected, j);
    		}
    	}
    }
}