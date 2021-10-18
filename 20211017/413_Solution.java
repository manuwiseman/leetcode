// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         if (nums == null || nums.length < 3) {
//             return 0;
//         }
        
//         int sum = 0;
//         int[] dp = new int[nums.length];
//         dp[0] = dp[1] = 0;
//         for (int i = 2; i < nums.length; i++) {
//             if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
//                 dp[i] = dp[i - 1] + 1;
//                 sum += dp[i];
//             }
//         }
//         return sum;    
//     }
// }



class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int sum = 0;
        int dp = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp += 1;
                sum += dp;
            } else {
                dp = 0;
            }
        }
        return sum;    
    }
}