class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> a[1] - b[1]));
        
        int count = 0, pre = 0, cur = 1;
        while (pre < intervals.length && cur < intervals.length) {
            if (intervals[pre][1] <= intervals[cur][0]) pre = cur;
            else count++;
            cur++;
        }
        
        return count;
    }
}