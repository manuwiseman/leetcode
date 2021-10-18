class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(maxRob(nums, 0, n - 2), maxRob(nums, 1, n - 1));
    }

    private void maxRob(int nums, int start, int end){
    	int pre1 = 0;
    	int pre2 = 0;

    	for (int i = 0; i < nums.length; i++) {
    		int cur = Math.max(pre1 + nums[i], pre2);
    		pre1 = pre2;
    		pre2 = cur;
    	}
    	return pre2;
    }
}