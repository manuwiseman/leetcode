class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // sort the elements in points based on their distance to origin
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        
        for (int[] point : points) {
            pq.add(point);
            while (pq.size() > k) pq.poll();
        }
        
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}