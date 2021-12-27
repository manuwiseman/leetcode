class Solution {
    public int minSwaps(int[] data) {
        // 1. for loop to get the number of 1
        int numberOfOnes = 0, ans = Integer.MAX_VALUE;
        for (int d : data) {
            if (d == 1) numberOfOnes++;
        }
        if (numberOfOnes == 0) return 0;
        // 2. for loop to check for each subarray with length of numberOfOnes
        // how many swap we need
        int numberOfZeros = 0;
        for (int i = 0; i < numberOfOnes - 1; i++) {
            if (data[i] == 0) numberOfZeros++;
        }
        for (int i = numberOfOnes - 1; i < data.length; i++) {
            if (data[i] == 0) numberOfZeros++;
            if (i >= numberOfOnes) numberOfZeros -= (data[i - numberOfOnes] == 0 ? 1 : 0);      
            ans = Math.min(ans, numberOfZeros);
        }
        return ans;
    }
}