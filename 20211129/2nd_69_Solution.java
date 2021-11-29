class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if (sq == x) return mid;
            else if (sq < x) left = mid + 1;
            else right = mid - 1;
        }
        
        return right;
    }
}