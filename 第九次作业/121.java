public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int profit=0,minPrice=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<minPrice) minPrice=prices[i];
            else if((prices[i]-minPrice)>profit)
            profit=(prices[i]-minPrice);
        }
        return profit;
    }
}