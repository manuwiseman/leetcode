class Solution {
    public int maxProfit(int[] inventory, int orders) {
        long max = 0;
        int modulo = 1000000007;
        // 1. sort the inventory array
        // after sort the array would look like, e.g.
        // 1, 2, 3, 4, 5, 5, 6, 6, 7 -> 7 -> 1...5, 6, 6, 6
        // 3, 6, 6, 6 (6 + 5 + 4) * 3 -> (inventory[idx] + inventory[next] + 1) / 2 * (invetory[idx] - inventory[next]) * numberOfBalls
        Arrays.sort(inventory);
        
        // 2. we track largest element(idx) and 2nd largest element(next) in the array
        int curIdx = inventory.length - 1, curVal = inventory[curIdx];
        while (orders > 0) {
            while (curIdx >= 0 && inventory[curIdx] == curVal) curIdx--;
            // nextVal can't be less than 0, in this case all element are equal
            int nextVal = (curIdx < 0 ? 0 : inventory[curIdx]);
            int numberOfBalls = inventory.length - 1 - curIdx;
            // the number of orders until next check
            int numberOfOrders = (curVal - nextVal) * numberOfBalls;
            if (orders >= numberOfOrders) {
                max += (long)(curVal + nextVal + 1) * (curVal - nextVal) / 2 * numberOfBalls;
            } else {
                // we can at most do x orders for each ball
                int x = orders / numberOfBalls;
                int remainder = orders % numberOfBalls;
                max += (long)(2 * curVal - x + 1) * x / 2 * numberOfBalls;
                max += (long)remainder * (curVal - x);
            }
            orders -= numberOfOrders;
            max = max % modulo;
            curVal = nextVal;
        }
        
        return (int) max;
    }
}