class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] parents = new int[isConnected.length];
        Arrays.fill(parents, -1);

        for (int i = 0; i < isConnected.length; i++ ){
        	for (int j = 0; j < isConnected.length; j++) {
        		if (isConnected[i][j] == 1) {
        			union(parents, i, j);
        		}
        	}
        }

        int res = 0;
        for (int i = 0; i < parents.length; i++) {
        	if (parents[i] == -1) res++;
        }

        return res;
    }

    private void union(int[] parents, int i, int j) {
    	int parentI = find(parents, i);
    	int parentJ = find(parents, j);

    	if (parentI != parentJ) {
    		parents[parentI] = parentJ;
    	}
    }

    private int find(int[] parents, int i) {
    	if (parents[i] == -1) return i;
    	return find(parents, parents[i]);
    }
}