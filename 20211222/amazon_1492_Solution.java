class Solution {
    public int kthFactor(int n, int k) {
        int sqrt = (int) Math.sqrt(n);
        List<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) return i;
                divisors.add(i);
            }
        }
        
        // if sqrt is the perfect square root
        // we have to skip to avoid duplicate
        if (sqrt * sqrt == n) k++;
        int len = divisors.size();
        return k <= len ? n / (divisors.get(len - k)) : -1;
    }
}