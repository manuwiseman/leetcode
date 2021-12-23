//ABCADBAEF
class Solution {
    public int uniqueLetterString(String s) {
        int N = s.length(), res = 0;
        int[][] array = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(array[i], -1);
        }
        
        for (int i = 0; i < N; i++) {
            int key = s.charAt(i) - 'A';
            res += (i - array[key][1]) * (array[key][1] - array[key][0]);
            array[key] = new int[]{array[key][1], i};
        }
        
        for (int i = 0; i < 26; i++) {
            res += (N - array[i][1]) * (array[i][1] - array[i][0]);
        }
        
        return res;
    }
}