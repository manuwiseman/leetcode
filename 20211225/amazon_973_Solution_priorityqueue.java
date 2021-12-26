class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] p : points) {
            pq.add(p);
        }
        
        int idx = 0;
        while (k > 0) {
            ans[idx++] = pq.poll();
            k--;
        }
        
        return ans;
    }
}