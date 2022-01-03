// [[1,2],[2,3],[3,4],[1,2]]
// [[1,2],[1,2],[2,3],[3,4]]
class Solution {
    public int maxEvents(int[][] events) {
        // 1. sort the events based on start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // 2. use priority queue to greedily attend meeting ends the soonest
        // pq sort events based on end time
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int ans = 0, idx = 0, day = 0, n = events.length;
        while (!pq.isEmpty() || idx < n) {
            // day of first event
            if (pq.isEmpty()) {
                day = events[idx][0];
            }
            // add the end days of all events already started into pq
            while (idx < n && events[idx][0] <= day) {
                pq.add(events[idx++][1]);
            }
            // attend the event
            pq.poll();
            ans++;
            day++;
            // remove events already ended 
            while(!pq.isEmpty() && pq.peek() < day) pq.poll();
        }
        return ans;
    }
}