class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0, indexS = 0;
        
        while(indexG < g.length && indexS < s.length) {
            if (g[indexG] <= s[indexS]) {
                indexG++;
            }
            indexS++;
        }
        return indexG;
    }
}