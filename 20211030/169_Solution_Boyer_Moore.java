class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, majority = 0;
        for (int num : nums) {
            majority = (count == 0) ? num : majority;
            count = (majority == num) ? count + 1 : count - 1;
        }
        
        return majority;
    }
}