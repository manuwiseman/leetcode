class Solution {
    public int maxProfit(int[] prices) {
        int held = Integer.MIN_VALUE, sold = Integer.MIN_VALUE, rest = 0;

        for (int price : prices) {
        	held = Math.max(held, rest - price);
        	rest = Math.max(rest, sold);
        	sold = held + price;
        }

        return Math.max(rest, sold);
    }
}