class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];
            res[start] += val;
            if (end < length - 1) {
                // since later we will add the val back
                // we will take off val starting from index end + 1
                res[end + 1] -= val;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        
        return res;
    }
}