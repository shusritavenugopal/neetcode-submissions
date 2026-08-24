class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            result = Math.max(result, (prices[i] - buyPrice));
        }
        return result;
    }
}
