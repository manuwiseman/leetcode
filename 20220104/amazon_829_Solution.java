// 1. odd number can obviously be broken into 2 consecutive number
// 2. if n % 3 = 0
// (start_num + end_num) * #_of_nums / 2 -> 1 + 2 + 3 + 4 + 5 = (1 + 5) * 5  / 2 = 15
// (x + x + k - 1) * k / 2 = n - > (2x + k - 1) * k /2 = n -> x = (2n / k + 1 - k) / 2
class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; i <= (int)Math.sqrt(2 * n); i++) {
            if ((2 * n / i + 1 - i) / 2 < 1) break;
            if ((2 * n) % i == 0 && (2 * n / i + 1 - i) % 2 == 0) ans++;
        }
        return ans;
    }
}