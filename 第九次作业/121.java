public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int minPrice, maxPrice, maxProfit;
        minPrice = prices[0];
        maxPrice = prices[0];
        maxProfit = 0;
        int[] profits = new int[prices.length];
        profits[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
                maxProfit = maxPrice - minPrice >maxProfit ?maxPrice-minPrice:maxProfit;
            } else if (prices[i] < minPrice) {
                minPrice = prices[i];
                maxPrice = minPrice;
            }
            profits[i] = maxProfit;
        }
//        for (int i :profits){
//            out.print(i+" ");
//        }
//        out.println();
        return profits[profits.length - 1];
    }

}