class Solution {
    int[] nums;
    public void sortColors(int[] nums) {
        this.nums = nums;
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        while(cur <= p2) {
            if (nums[cur] == 0) swap(p0++, cur++);
            else if (nums[cur] == 1) cur++;
            else swap(p2--, cur);
        }
    }
    
    private void swap(int a, int b) {
        int temp = this.nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}