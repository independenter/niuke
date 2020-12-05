package year2020.month12.day05;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * <code>
 *     input: [2,3,4,5]
 *     output: 4
 *
 *     input: [2,2,3,4,3]
 *     output: 3
 * </code>
 *
 * @author independenter
 * @since
 */
public class Solution3 {
    public static void main(String[] args) {
        int[] input = randomInts(10000);
        long start = System.currentTimeMillis();
        Console.log(new Solution3().maxLength(input));
        Console.log("bitset所用时间{}ms" ,System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        Console.log(new Solution3().maxLength1(input));
        Console.log("map所用时间{}ms" ,System.currentTimeMillis() - start);
    }

    public static int[] randomInts(int len){
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = RandomUtil.randomInt(1000000);
        }
        return result;
    }

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        BitSet bitSet = new BitSet();
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0,j = 0; j < arr.length; j++) {
            //判断有添加
            if(bitSet.get(arr[j]) && map.containsKey(arr[j])){
                //挪动初始的i的位置
                i = Math.max(i,map.get(arr[j]) + 1);
            }
            count = Math.max(count, j-i + 1);
            bitSet.set(arr[j]);
            map.put(arr[j],j);
        }
        return count;
    }

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength1 (int[] arr) {
        // write code here
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0,j = 0; j < arr.length; j++) {
            //判断有添加
            if(map.containsKey(arr[j])){
                //挪动初始的i的位置
                i = Math.max(i,map.get(arr[j]) + 1);
            }
            count = Math.max(count, j-i + 1);
            map.put(arr[j],j);
        }
        return count;
    }
}
