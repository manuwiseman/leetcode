class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); n++) {
        	String bitString = Integer.toBinaryString(i).substring(1);
        	List<Integer> list =  new ArrayList<>();
        	for (int j = 0; j < n; j++) {
        		if (bitString.charAt(j) == '1') list.add(nums[j]);
        	}
        	res.add(list);
        }
        return res;
    }
}