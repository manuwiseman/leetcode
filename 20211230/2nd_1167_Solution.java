class Solution {
    public int connectSticks(int[] sticks) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int stick : sticks) {
            pq.add(stick);
        }
        
        while (pq.size() >= 2) {
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int sum = stick1 + stick2;
            res += sum;
            pq.add(sum);   
        }
        
        return res;
    }
}