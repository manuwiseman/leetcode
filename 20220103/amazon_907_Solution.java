// 3, 1, 2, 4, 3
// 3
// 4, 3
// 2, 4, 3
// 1, 2, 4, 3
// 3, 1, 2, 4, 3
/// dp[4] = dp[2] + (4 - 2) * 3
// so 1.we need to have a data structure that tracks the minimum idx
// 2. a DP that can accomplish dp[cur_idx] = dp[pre_min_idx] + (cur_idx - pre_min_idx) * arr[i]
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int ans = 0, modulo = (int) 1e9 + 7;
        Stack<Integer> stack = new Stack<Integer>();
        // push dummy idx
        stack.push(-1);
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            // pop until we find pre_min_idx
            while (stack.peek() != -1 && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // dp[i + 1] -> sum of subarray minimums ending in i in arr
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * arr[i]) % modulo;
            stack.push(i);
            ans += dp[i + 1];
            ans %= modulo;
        }
        
        return ans;
    }
}