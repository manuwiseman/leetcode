class Solution {
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length - 1, i = 0;
        while (i <= hi) {
            if (nums[i] == 0) {
                swap(nums, lo++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, hi--);
            } else {
                i++;
            }
        }
    }
    
    private void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}