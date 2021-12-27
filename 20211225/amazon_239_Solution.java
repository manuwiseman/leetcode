class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return nums;
        this.nums = nums;
        
        // 1. first sliding window
        int maxIdx = 0;
        for (int i = 0; i < k; i++) {
            // clear the deque and add current element
            clearDeque(i, k);
            deq.addLast(i);
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int[] output = new int[n - k + 1];
        output[0] = nums[maxIdx];
        
        // iterate and process each sliding window
        for (int i = k; i < n; i++) {
            clearDeque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        
        return output;
    }
    
    private void clearDeque(int i, int k) {
        // remove the index that's no longer in current sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        // remove the indices whose value are smaller than current value
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }
}