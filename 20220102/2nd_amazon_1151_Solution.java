class Solution {
    public int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int left = 0, right = 0, count = 0, maxCount = 0;
        
        while (right < data.length) {
            count += data[right++];
            if (right - left > ones) {
                count -= data[left++];
            }
            maxCount = Math.max(maxCount, count);
        }
        
        return ones - maxCount;
    }
}