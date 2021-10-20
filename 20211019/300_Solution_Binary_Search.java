class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
    
    private int binarySearch(List<Integer> list, int key) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == key) {
                return mid;
            } else if (list.get(mid) < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}