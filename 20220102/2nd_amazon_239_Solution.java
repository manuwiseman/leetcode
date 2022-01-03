// we not only need to know the max element in the sliding window
// we also need to know max's posistion so we know in next sliding window
// whether this elemtn still exists or not
class Solution {
    ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
    int[] nums;
    int k;
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int[] ans = new int[nums.length - k + 1];
        this.nums = nums;
        this.k = k;
        
        // 1st sliding window
        int idx = 0;
        for (int i = 0; i < k; i++) {
            clear(i);
            dq.addLast(i);
        }
        ans[idx++] = nums[dq.getFirst()];
        
        // rest of sliding windows
        for (int i = k; i < nums.length; i++) {
            clear(i);
            dq.addLast(i);
            ans[idx++] = nums[dq.getFirst()];
        }
        
        return ans;
    }
    
    private void clear(int i) {
        // remove the elements that's no in current sliding window
        if (!dq.isEmpty() && dq.getFirst() == i - k) {
            dq.removeFirst();
        }
        // remove the elements that's less than current element since they are not possible to be the maximum
        while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
            dq.removeLast();
        }
    }
}