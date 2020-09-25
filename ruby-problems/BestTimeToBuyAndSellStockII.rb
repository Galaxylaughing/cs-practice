# source: LeetCode
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

# 122. <easy> Best Time to Buy and Sell Stock II
=begin
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 

Constraints:

    1 <= prices.length <= 3 * 10 ^ 4
    0 <= prices[i] <= 10 ^ 4
=end

# @param {Integer[]} prices
# @return {Integer}
def max_profit(prices)
    num_days = prices.length()
    max_profit = 0
    previous_profit = 0

    i = 0
    j = 1
    while i < num_days && j < num_days
        current_profit = prices[j] - prices[i]

        if current_profit > previous_profit
            previous_profit = current_profit
            j += 1
        else
            max_profit += previous_profit
            previous_profit = 0
            i = j
            j += 1
        end

        if i >= num_days || j >= num_days
            max_profit += previous_profit
        end
    end
    return max_profit
end

=begin
201 / 201 test cases passed.
Runtime: 40 ms
Memory Usage: 9.9 MB
=end

