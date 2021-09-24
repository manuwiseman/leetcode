class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] list = new int[60];
        Arrays.fill(list, 0);
        int res = 0;
        for (int t : time) {
            list[t % 60]++;
        }
        
        for (int i = 1; i < 30; i++) {
            if (list[i] > 0 && list[60 - i] > 0) {
                res += list[i] * list[60 - i];
            }
        }
        
        if (list[0] > 0) res += list[0] * (list[0] - 1) / 2;
        if (list[30] > 0) res += list[30] * (list[30] - 1) / 2;
        
        return res;
    }
}