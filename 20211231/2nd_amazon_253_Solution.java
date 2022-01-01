class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 1. sort the array based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 2. loop thru sorted array and count the number of meetings room needed
        int min = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // if the earliest ending meetings has ended already
            // we can re-use the room (by pop it out from queue and insert new one)
            if (pq.peek()[1] <= intervals[i][0]) {
                pq.poll();
            }
            // we always need to insert the new meeting into pq anyway
            pq.add(intervals[i]);
            min = Math.max(min, pq.size());
        }
        
        return min;
    }
}