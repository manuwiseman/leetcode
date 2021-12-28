class Solution {
    public int maxEvents(int[][] events) {
        // 1. sort the array based on start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // 2. priorityqueue to store events based on end time
        // we greedily attend the events ending the soonest
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int res = 0, day = 0, i = 0, n = events.length;
        while (!pq.isEmpty() || i < n) {
            // first day having event
            if (pq.isEmpty()) {
                day = events[i][0];
            }
            // add all events that already started in pq
            while (i < n && events[i][0] <= day) {
                pq.add(events[i++][1]);
            }
            // attend the event
            pq.poll();
            res++;
            day++;
            // if event already before day
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }
        
        return res;
    }
}