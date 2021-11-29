class Solution {
    public int findMinArrowShots(int[][] points) {
        // sort the array based on Xstart
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        
        int pre = 0, cur = 1, count = 1;
        
        while (cur < points.length) {
            if ((long)points[pre][1] < (long)points[cur][0]) {
                count++;
                pre = cur;
            }
            cur++;
        }
        
        return count;
    }
}