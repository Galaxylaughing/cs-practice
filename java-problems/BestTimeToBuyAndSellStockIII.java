// source: LeetCode

// 123. <hard> Best Time To Buy And Sell Stock III
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Example 4:

Input: prices = [1]
Output: 0

Constraints:

    1 <= prices.length <= 10^5
    0 <= prices[i] <= 10^5
*/

// SOLUTION TWO
class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) { return 0; }
        
        int[] maxProfitLeft = new int[prices.length];
        int[] maxProfitRight = new int[prices.length];
        int currProfit = 0;
        
        // calculate max profit to the left
        maxProfitLeft[0] = 0;
        int prevMinPrice = Integer.MAX_VALUE;
        for (int day = 1; day < prices.length; day++) {
            int prevProfit = maxProfitLeft[day - 1];
            int prevPrice = prices[day - 1];
            prevMinPrice = (prevMinPrice <= prevPrice) ? prevMinPrice : prevPrice;
            
            currProfit = prices[day] - prevMinPrice;            
            maxProfitLeft[day] = (currProfit > prevProfit) ? currProfit : prevProfit;
        }
        
        // calculate max profit to the right
        maxProfitRight[prices.length - 1] = 0;
        int prevMaxPrice = Integer.MIN_VALUE;
        for (int day = prices.length - 2; day >= 0; day--) {
            int prevProfit = maxProfitRight[day + 1];
            int nextPrice = prices[day + 1];
            prevMaxPrice = (prevMaxPrice >= nextPrice) ? prevMaxPrice : nextPrice;
            
            currProfit = prevMaxPrice - prices[day];
            maxProfitRight[day] = (currProfit > prevProfit) ? currProfit : prevProfit;
        }
        
        // find maximum combination of left and right
        int maxProfit = 0;
        for (int day = 0; day < prices.length; day++) {
            currProfit = maxProfitLeft[day] + maxProfitRight[day];
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }
        
        return maxProfit;
    }
}
/*
214 / 214 test cases passed.
Runtime: 5 ms
Memory Usage: 53.9 MB
*/

// SOLUTION ONE
/*
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) { return 0; }
        // if there are fewer than 4 prices, only one transaction can be made
        if (prices.length < 4) { return maxProfitForTransaction(prices); }

        List<Integer> partitionProfits = new ArrayList<Integer>();
        partitionProfits.add(maxProfitForTransaction(prices));

        // for each partition,
        // sum max profit from either sides of partition
        for (int i = 2; i < prices.length; i++) {
            int maxProfitRight = maxProfitForTransaction(Arrays.copyOfRange(prices, 0, i));
            int maxProfitLeft = maxProfitForTransaction(Arrays.copyOfRange(prices, i, prices.length));
            partitionProfits.add(maxProfitRight + maxProfitLeft);
        }

        return getMax(partitionProfits);
    }

    private int maxProfitForTransaction(int[] prices) {
        int minPriceDay = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minPriceDay]) {
                minPriceDay = i;
            } else if (prices[i] - prices[minPriceDay] > maxProfit) {
                maxProfit = prices[i] - prices[minPriceDay];
            }
        }
        return maxProfit;
    }

    private int getMax(List<Integer> profits) {
        int max = 0;
        for (Integer profit : profits) {
            if (profit > max) {
                max = (int) profit;
            }
        }
        return max;
    }
}
*/
// TIMED OUT on a LeetCode test

