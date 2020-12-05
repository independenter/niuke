package year2020.month12.day05;

import cn.hutool.core.lang.Console;

/**
 * <p>给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 * <code>
 *     input: 7,2
 *     output: 111
 * </code>
 * <analysis>
 *
 * </analysis>
 *
 * @author independenter
 * @since
 */
public class Solution11 {

    private static Solution11 INSTANCE = new Solution11();

    public static void main(String[] args) {
        Console.log(INSTANCE.solve(35,18));
    }

    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        // write code here
        if(M == 0){
            return "0";
        }
        char[] chars = new char[N];
        for (int i = 0; i < N; i++) {
            if(i < 10) {
                chars[i] = (char) (48 + i);//0
            }else{
                chars[i] = (char) (55 + i);//A
            }
        }
        //处理
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if(M < 0) {
            M = -M;
            flag = true;
        }
        for (;M!=0;M/=N){
            sb.append(chars[M%N]);
        }
        if(flag){
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
