class Solution {
	public int binarySearch(int[] nums, int key) {
		int start = 0, end = nums.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == key) return mid;
			if (nums[mid] < key) {
				start = mid + 1;
			} else {
				end = mid + 1;
			}
		}
		return -1;
	}
}