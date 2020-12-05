package year2020.month12.day05;

import cn.hutool.core.lang.Console;

/**
 * <p> 跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <code>
 *     1: 1                     1
 *     2: 1+1 | 2               2
 *     3: 1+1+1| 1+2|2+1        3
 *     4: 1+1+1+1| 1+2+1| 2+1+1| 1+1+2| 2+2 5
 * </code>
 * <analyze>
 *     满足斐波那契数列
 *     n = n-1 + n -2
 * </analyze>
 *
 * @author independenter
 * @since
 */
public class Solution4 {

    public static void main(String[] args) {
        Console.log(new Solution4().JumpFloor(4));
    }

    public int JumpFloor(int target) {
        if(target <= 0) {
            return 0;
        }
        return fibonacciForIter(target);
    }

    //递归
    public static int fibonacciForRecursion(int target){
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            return fibonacciForRecursion(target-1) + fibonacciForRecursion(target-2);
        }
    }

    public static int fibonacciForIter(int target){
        if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
