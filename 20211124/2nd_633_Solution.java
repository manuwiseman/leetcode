class Solution {
    public boolean judgeSquareSum(int c) {
        int p1 = 0; 
        long p2 = (long) Math.sqrt(c);
        while (p1 <= p2) {
            long sum = p1 * p1 + p2 * p2;
            if (sum == c) return true;
            else if (sum < c) p1++;
            else p2--;
        }
        return false;
    }
}