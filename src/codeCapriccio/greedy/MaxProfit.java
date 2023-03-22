package codeCapriccio.greedy;

public class MaxProfit {
    /*
    * 题意（leetcode122. 买卖股票的最佳时机 II）：
    *   给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
    *   在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
    *   返回 你能获得的 最大 利润。
    * 解题思路：
    *   局部最优：每一次买入都在第二天就能赚才买入，买入第二天就卖
    *   全局最优：多次买入一天就卖出，最终合起来就是全局最优
    */

    public int maxProfit(int[] prices) {
        int profit = 0;
        // 只有一天或空数组时不买入
        if(prices.length < 2)
            return profit;
        for (int i = 0; i < prices.length - 1; i++) {
            // 只有第二天价格涨时买入，且在第二天立即卖出
            if(prices[i] < prices[i+1]){
                profit = profit - prices[i] + prices[i+1];
            }
        }
        return profit;
    }
}
