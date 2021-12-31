// 12 -> [1, 2, 3, 4, 6, 12]
// sqrt = 3
// 16 -> [1, 2, 4, 8, 16]
class Solution {
    public int kthFactor(int n, int k) {
        // 1. check from 1 til sqrt to see if we can find the kth factor
        int sqrt = (int) Math.sqrt(n);
        List<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                k--;
                divisors.add(i);
            }
            if (k == 0) return i;
        }
        // 2. check if sqrt is perfect sqrt, pop the stack
        if (sqrt * sqrt == n) k++;
        
        int len = divisors.size();
        return k > len ? -1 : n / (divisors.get(len - k));
    }
}