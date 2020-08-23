/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/23 23:16
 * @Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {
    // 贪心算法
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int yesterday = prices[i - 1];
            int today = prices[i];
            int res = today - yesterday;
            if (res > 0) {
                profit += res;
            }
        }
        return profit;
    }

    // 常规思路解题
    public int maxProfit1(int[] prices) {
        int profit = 0;
        int valley = prices[0];
        int peak = prices[0];
        int i = 0;
        // 前后相比，防止越界所以-1
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }

    // 动态规划
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        // 0表示持有现金，1表示持有股票
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 从第二天开始
         for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 与上相反
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit.maxProfit1(prices));
        System.out.println(maxProfit.maxProfit2(prices));
    }
}
