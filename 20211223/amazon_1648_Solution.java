// 1, 5, 3, 7, 9, 9, order = 10 -> 1, 3, 5, 7, 9, 9
// 1, 3, 5, 7, 7, 7, order = 6, profit = 9 * 2 + 8 * 2, if largest element is 100
// then profit would be 100 * 2 + 99 * 2 + ...
// 1 + 2 + 3 + ... + n = (1 + n) * n / 2

// profit += (largest_val + next_largest_val + 1) * (largest_val - next_val) / 2 * numberOfBalls


class Solution {
    public int maxProfit(int[] inventory, int orders) {
        long profit = 0;
        int modulo = 1000000007;
        Arrays.sort(inventory);
        int curIndex = inventory.length - 1;
        int curVal = inventory[curIndex]; 
        
        while (orders > 0) {
            // handle case e.g. 3, 3, 3, 3 avoid out of boud index exception
            while (curIndex >= 0 && curVal == inventory[curIndex]) {
                curIndex--;
            }
            // if all balls have same value then nextVal is 0
            int nextVal = (curIndex < 0 ? 0 : inventory[curIndex]);
            int numOfBalls = inventory.length - 1 - curIndex;
            int numOfSales = numOfBalls * (curVal - nextVal);
            if (orders >= numOfSales) {
                profit += (long)(curVal + nextVal + 1) * (curVal - nextVal) / 2 * numOfBalls;
            } else {
                int numOfFullRow = orders / numOfBalls;
                int remainder = orders % numOfBalls;
                profit += (long)(curVal + curVal - numOfFullRow + 1) * numOfFullRow / 2 * numOfBalls;
                profit += (long)remainder * (curVal - numOfFullRow);
            }
            orders -= numOfSales;
            profit = profit % modulo;
            curVal = nextVal;
        }
        
        return (int) profit;
    }
}