class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int hottest = 0;
        
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int curTemp = temperatures[i];
            if (curTemp >= hottest) {
                hottest= curTemp;
                continue;
            }
            
            int days = 1;
            while (temperatures[i + days] <= curTemp) {
                days += ans[i + days];
            }
            ans[i] = days;
        }
        
        return ans;
    }
}