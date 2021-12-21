class Solution {
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        int N = s.length();
        int res = 0;
        
        for (int i = 0; i < 26; i++) {
            Arrays.fill(index[i], -1);
        }
        
        for (int i = 0; i < N; i++) {
            int c = s.charAt(i) - 'A';
            res += (i - index[c][1]) * (index[c][1] - index[c][0]);
            index[c] = new int[]{index[c][1], i};
        }
        
        for (int c = 0; c < 26; c++) {
            res += (N - index[c][1]) * (index[c][1] - index[c][0]);
        }
        
        return res;
    }
}