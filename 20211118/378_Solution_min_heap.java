class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int j = 0; j < n; j++) {
            pq.add(new Tuple(0, j, matrix[0][j]));
        }
        
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == m - 1) continue;
            pq.add(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple>{
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
    
}