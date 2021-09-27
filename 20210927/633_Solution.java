class Solution {
    public boolean judgeSquareSum(int c) {
        int start = 0;
        long end = (long) Math.ceil(Math.sqrt(c));
        while (start <= end) {
            long sum = start * start + end * end;
            if (sum == c) return true;
            else if (sum < c) start++;
            else end--;
        }
        return false;
    }
}