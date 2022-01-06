class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return quickselect(points, k);
    }
    
    private int[][] quickselect(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        int pivotIdx = points.length;
        while (pivotIdx != k) {
            pivotIdx = partition(left, right, points);
            if (pivotIdx < k) {
                left = pivotIdx;
            } else {
                right = pivotIdx - 1;
            }
        }
        return Arrays.copyOf(points, k);
    }
    
    private int partition(int left, int right, int[][] points) {
        int[] pivot = choosePivot(left, right, points);
        int pivotDist = getSquareDist(pivot);
        while (left < right) {
            if (getSquareDist(points[left]) >= pivotDist) {
                swap(points, left, right);
                right--;
            } else {
                left++;
            }
        }
        if (getSquareDist(points[left]) < pivotDist) left++;
        return left;
    }
    
    private int[] choosePivot(int left, int right, int[][] points) {
        return points[left + (right - left) / 2];
    }
    
    private int getSquareDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int left, int right) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }
}