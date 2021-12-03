class Solution {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        q.add(n);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size-- > 0) {
                int remainder = q.poll();
                for (int sq : squares) {
                    int next = remainder - sq;
                    if (next == 0) return count;
                    if (next < 0) break;
                    if (visited[next]) continue;
                    q.add(next);
                    visited[next] = true;
                }
            }      
        }
        return n;
    }
    
    private List<Integer> generateSquares(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            list.add(i * i);
        }
        return list;
    }
}