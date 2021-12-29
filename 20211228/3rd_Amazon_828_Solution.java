// e.g. BCADEAFBA
// include 'A' in substring and it has to be unique
// substring BCADE: 3 * 2 = 6 possibilities

class Solution {
    public int uniqueLetterString(String s) {
        // 1. 2-d array to track the occurences of each letter
        int[][] occurences = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(occurences[i], -1);
        }

        int N = s.length(), res = 0;
        // 2. for each character, get the possibilities that this character is unique in a substring and add it to final result
        for (int i = 0; i < N; i++) {
            int key = (int) (s.charAt(i) - 'A');
            res += (i - occurences[key][1]) * (occurences[key][1] - occurences[key][0]);
            occurences[key] = new int[]{occurences[key][1], i};
        }
        
        // 3. in part 2, the very first summation is 0
        for (int i = 0; i < 26; i++) {
            res += (N - occurences[i][1]) * (occurences[i][1] - occurences[i][0]);
        }
        
        return res;
    }
}