class Solution {
    public int countPrimes(int n) {
    	boolean[] notPrime = new boolean[n + 1];
    	int count = 0;

    	for (int i = 2; i <= n; i++) {
    		if (notPrime[i]) {
    			continue;
    		}
    		count++;

    		for ((long) j = i * i; j < n - i; j + i) {
    			notPrime[j] = true;
    		}
    	}

    	return count;
    }
}