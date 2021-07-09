package leetcode.greedy;

/*
*
*
* 题目描述：一次交易包含买入和卖出，多个交易之间不能交叉进行。
对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
* 而 d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加加到收益中，从而在局部最优的情况下也保证全局最优。
*
*
* */
public class LT122_Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                profit += (prices[i] - prices[i-1]);
        }
        return profit;
    }
}
