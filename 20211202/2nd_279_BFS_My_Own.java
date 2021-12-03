// 10 = 1 + 9
// 26 = 1 + 25
// 29 = 4 + 25
// 12 = 9 + 1 + 1 + 1 || 4 + 4 + 4
class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size-- > 0) {
                int sum = q.poll();
                for (int i = (int) Math.sqrt(n - sum); i >= 1 ; i--) {
                    sum += i * i;
                    //System.out.println("sum: " + sum + ", count: " + count);
                    if (sum == n) return count;
                    q.add(sum);
                    sum -= i * i;
                }
            }      
        }
        return n;
    }
}