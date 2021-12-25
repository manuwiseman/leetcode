// "cat","dog","catdog", "cotdag"
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        Set<String> wordDict = new HashSet<String>();
        int n = words.length;
        // if length is less then 3 then not possible to find any qualified word
        if (n < 3) return ans;
        
        // sort the array based on length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for (int i = 0; i < n; i++) {
            if (canForm(words[i], wordDict)) ans.add(words[i]);
            wordDict.add(words[i]);
        }
        
        return ans;
    }
    
    // word break leetcode 139. Word Break
    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}