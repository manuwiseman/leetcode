class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
        	set.add(num);
        }

        int longestStreak = 0;
        for (int num : set) {
        	if (!set.contains(num - 1)) {
        		int streak = 1;
        		int cur = num;

        		while (set.contains(cur + 1)) {
        			cur++;
        			streak++;
        		}
                longestStreak = Math.max(longestStreak, streak);
        	}
        }

        return longestStreak;
    }
}