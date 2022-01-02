class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        if (words.length < 3) return ans;
        Set<String> wordDict = new HashSet<String>();
        
        // 1. sort the array based on string length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // 2. for each string, check if word is concatenated
        for (String word : words) {
            if (canForm(word, wordDict)) ans.add(word);
            wordDict.add(word);
        }
        
        return ans;
    }
    
    public boolean canForm(String word, Set<String> wordDict) {
        if (wordDict.isEmpty()) return false;
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (wordDict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}