class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
        	if (color[i] == -1) {
        		Stack<Integer> stack = new Stack<Integer>();
        		stack.push(i);
        		color[i] = 0;
                
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;     
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
        	}
        }

        return true;
    }
}