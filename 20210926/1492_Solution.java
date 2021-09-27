class Solution {
    public int kthFactor(int n, int k) {
        int sqrt = (int) Math.sqrt(n);
        List<Integer> divisor = new ArrayList<Integer>();
        for (int i = 1; i < sqrt + 1; i++) {
        	if (n % i == 0){
        		k--;
        		if (k == 0) return i;
        		divisor.add(i);
        	}
        }

        // if sqrt is the perfect square root
        if (sqrt * sqrt == n) k++;

        int len = divisor.size();
        return k <= len ? n / divisor.get(len - k) : -1;
    }
}