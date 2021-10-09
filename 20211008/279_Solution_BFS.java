class Solution {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        int level = 0;

        while (!queue.isEmpty()) {
        	int size = queue.size();
        	level++;
        	while (size-- > 0) {
        		int current = queue.poll();
        		for (int s : squares) {
        			int next = current - s;
        			if (next < 0) break;
        			if (next == 0) return level;
        			if (visited[next]) continue;
        			visited[next] = true;
        			queue.add(next);
        		}
        	}
        }
        return n;
    }

    private List<Integer> generateSquares(int n) {
    	List<Integer> list = new ArrayList<Integer>();
    	int max_sqrt = (int) Math.sqrt(n);
    	for (int i = 0; i <= max_sqrt; i++) {
    		list.add(i * i);
    	}
    	return list;
    }
}