package year2020.month12.day04;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * <code>
 *     input:
 *          [4,5,1,6,2,7,3,8],4
 *     output:
 *          [1,2,3,4]
 * </code>
 *
 * @author independenter
 * @since
 */
public class Solution1 {

    private static final int[] input = {4,5,1,6,2,7,3,8};//1

    public static void main(String[] args) {
        List<Integer> result = new Solution1().GetLeastNumbers_Solution(input,1);
        Console.log(result);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if(k> input.length) {
            return new ArrayList<>();
        }
        getLeftIndex(input,0,input.length-1,k);//小于第k位的都挪到前面
        return array2List(input,k);
    }

    public static ArrayList<Integer> array2List(int[] input,int p){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i=0;i<p;i++){
            integers.add(input[i]);
        }
        return integers;
    }

    public static int getLeftIndex(int[] input,int left,int right,int k){
        if(left < right){
            int p = getLeftIndex(input,left,input.length-1);
            if(k == p){
                return k;
            }else if(k > p){
                return getLeftIndex(input,p,right,k);
            }else {
                return getLeftIndex(input,left,p-1,k);
            }
        }
        return -1;
    }

    public static int getLeftIndex(int[] input,int left,int right){
        int p = input[left];
        while(left<right){
            //把小的向前移
            while (left < right && input[right] >= p){
                right--;
            }
            input[left] = input[right];
            //大的向后移
            while (left < right && input[left] <= p){
                left++;
            }
            input[right] = input[left];
        }
        //right <= p <= left;
        input[left] = p;
        //左小 右大
        return left + 1;
    }
}
