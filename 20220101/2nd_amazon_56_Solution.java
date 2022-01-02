// [[2, 6],[15,18],[8,10],[1, 3]]
//
class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. sort the array based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 2. iterate the sorted array and merge intervals using list
        LinkedList<int[]> list = new LinkedList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            // candidate interval to merge
            if (!list.isEmpty()  && list.getLast()[1] >= intervals[i][0]) {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
            // nothing to merge
            else {
                list.add(intervals[i]);
            }
        }
        
        return list.toArray(new int[0][0]);
    }
}