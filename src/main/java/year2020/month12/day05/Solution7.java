package year2020.month12.day05;

import cn.hutool.core.lang.Console;

/**
 * <p>输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * <code>
 *     input: [1,-2,3,10,-4,7,2,-5]
 *     output: 18
 * </code>
 * <analysis>
 *     动态规划
 * </analysis>
 *
 * @author independenter
 * @since
 */
public class Solution7 {

    private static int[] input = {1,-2,3,10,-4,7,2,-5};
    private static Solution7 INSTANCE = new Solution7();

    public static void main(String[] args) {
        Console.log(INSTANCE.FindGreatestSumOfSubArray(input));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int count = array[0];
        for (int i = 1; i < len; i++) {
            if(array[i-1] >= 0){
                array[i] += array[i-1];
            }
            count = Math.max(count,array[i]);
        }
        return count;
    }
}
