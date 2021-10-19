class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] squares = generateSquares(n);
        int level = 0;
        q.add(n);

        while (!q.isEmpty()) {
        	int size = q.size();
        	level++;
        	while (size-- > 0) {
                int element = q.poll();
        		for (int sq : squares) {
	        		int x = element - sq;
	        		if (x < 0) continue;
	        		if (x == 0) return level;
	        		if (visited[x]) continue;
	        		visited[x] = true;
	        		q.add(x);
	        	}
        	}
        }
        return n;
    }

    private int[] generateSquares(int n) {
    	int max_sqrt = (int) Math.sqrt(n);
        int[] squares = new int[max_sqrt + 1];
    	for (int i = 1; i <= max_sqrt; i++) {
    		squares[i] = i * i;
    	}
    	return squares;
    }
}