class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
        	// diff the res[0] ^ res[1]
        	diff ^= num;
        }
        // the rightmost 1
        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums) {
        	if ((num & diff) == 0) res[0] ^= num;
        	else res[1] ^= num;
        }
        return res;
    }
}