package year2020.month12.day05;

import cn.hutool.core.lang.Console;

/**
 * <p>假设你有一个数组，其中第 i 个元素是股票在第 i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 * <code>
 *     input: [1,4,2]
 * </code>
 *
 * @author independenter
 * @since
 */
public class Solution10 {
    private static int[] input = {1,4,2,6};
    private static Solution10 INSTANCE = new Solution10();

    public static void main(String[] args) {
        Console.log(INSTANCE.maxProfit(input));
    }

    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        if(prices.length <= 1) {
            return 0;
        }
        int money = prices[0],profit = 0;//没有操作盈利多少
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < money){
                money = prices[i];
            }
            profit = Math.max(profit,prices[i] - money);
        }
        return profit;
    }
}
