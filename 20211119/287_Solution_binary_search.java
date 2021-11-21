class Solution {
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
        	int mid = l + (r - l) / 2;
        	int count = 0;
        	for (int i = 0; i < nums.length; i++) {
        		if (nums[i] <= mid) count++;
        	}
        	if (count > mid) r = mid - 1;
        	else l = mid;
        }
        return l;
    }
}