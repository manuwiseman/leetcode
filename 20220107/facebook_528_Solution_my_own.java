// thoughts: it's relatively easy for us to get a random number
// but it's difficult to find the range that random number falls in
// and we don't want to loop thru every element every time pickIndex() is called, which is O(n)
import java.util.Random;
class Solution {
    int total;
    int[] sums;

    public Solution(int[] w) {
        this.total = 0;
        this.sums = new int[w.length];
        // sums is sorted
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }
    
    // binary search for the index, which gives O(logN) time complexity
    public int pickIndex() {
        double random = this.total * Math.random();
        int left = 0, right = sums.length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (sums[mid] < random) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */