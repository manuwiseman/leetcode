// class Solution {
//     public int fib(int n) {
//         if (n < 2) return n;
//         return fib(n - 1) + fib(n - 2);
//     }
// }

class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int prev1 = 0, prev2 = 1, current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }
}