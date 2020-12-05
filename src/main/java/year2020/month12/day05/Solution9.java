package year2020.month12.day05;

import cn.hutool.core.lang.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 *
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 * <code>
 *     input: [3,2,4],6
 *     output: [2,3]
 * </code>
 *
 * @author independenter
 * @since
 */
public class Solution9 {

    private static int[] input = {3,2,4};
    private static Solution9 INSTANCE = new Solution9();

    public static void main(String[] args) {
        Console.log(INSTANCE.twoSum(input,6));
    }

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> defectMap = new HashMap<>();
        for (int i = 1; i <= numbers.length; i++) {
            int defectKey = target - numbers[i-1];
            if(defectMap.containsKey(defectKey)){
                return new int[]{defectMap.get(defectKey),i};
            }else{
                defectMap.put(numbers[i-1],i);
            }
        }
        return new int[2];
    }
}
