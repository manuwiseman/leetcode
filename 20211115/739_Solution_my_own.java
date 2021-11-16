class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<int[]>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                    int[] pop = stack.pop();
                    ans[pop[1]] = i - pop[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        
        return ans;
    }
}