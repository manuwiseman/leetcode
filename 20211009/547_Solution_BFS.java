class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        int res = 0;

        for (int i = 0; i < isConnected.length; i++) {
        	if (visited[i] == 0) {
        		queue.add(i);
	        	while (!queue.isEmpty()) {
	        		int node = queue.poll();
	        		visited[node] = 1;
	        		for (int j = 0; j < isConnected[node].length; j++) {
	        			if (isConnected[node][j] == 1 && visited[j] == 0) {
	        				queue.add(j);
	        			}
	        		}
	        	}
	        	res++;
        	}
        }

        return res;
    }
}