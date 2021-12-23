//1, 2, 4, 5, 8
// 1 + 2 = 3
// 1 + 2 + 4 = 7
// 1 + 2 + 4 + 5

class Solution {
    public int connectSticks(int[] sticks) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int stick : sticks) {
            pq.add(stick);
        }
        
        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int sum = s1 + s2;
            res += sum;
            pq.add(sum);
        }
        
        return res;
    }
}