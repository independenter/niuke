package year2020.month12.day05;

import cn.hutool.core.lang.Console;

/**
 * <p> 实现函数 int sqrt(int x).
 * 计算并返回x的平方根（向下取整）
 *
 * @author independenter
 * @since
 */
public class Solution5 {

    public static void main(String[] args) {
        int value = 343234;
        Console.log(new Solution5().sqrt(value  ));
        Console.log(new Solution5().mySqrt(value  ));
    }

    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int sqrt (int x) {
        // write code here
        if(x <= 0 ){
            return 0;
        }
        return sqrt(x,1,x);
    }

    public static int sqrt(int x,int left,int right){
        int middle = (left + right) >> 1;
        if(middle <= x / middle && (middle+1) > x / (middle+1)){
            return middle;
        }else if(middle > x / middle){
            //往下找
            return sqrt(x,left,middle-1);
        }else {
            //往上找
            return sqrt(x,middle + 1,right);
        }
    }

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        int left = 1, right = x;
        while (true) {
            int middle = (left + right) >> 1;
            if (middle <= x / middle && (middle+1) > x / (middle+1)) {
                return (int) middle;
            } else if (middle < x / middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    }
}
