class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        int anchor = 0, j = 0;
        List<Integer> ans = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            // j track the largest index that has appear so far
            j = Math.max(j, last[s.charAt(i) - 'a']);
            
            // if we iterate to largest index, it means we have a candidate substring
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = j + 1;
            }
        }
        return ans;
    }
}