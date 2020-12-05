package year2020.month12.day05;

import base.TreeNode;
import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>分别按照二叉树先序(根左右)，中序(左根右)和后序(左右根)打印所有的节点。
 * <code>
 *     input: {1,2,3}
 *     output: [[1,2,3],[2,1,3],[2,3,1]]
 * </code>
 *
 * @author independenter
 * @since
 */
public class Solution2 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,2,3);
        Console.log(new Solution2().threeOrders(treeNode));
    }

    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer>[] result = new ArrayList[3];//先,中,后
        result[0] = new ArrayList<>();
        result[1] = new ArrayList<>();
        result[2] = new ArrayList<>();
        forRecursion(root,result);
        int[][] ints = Arrays.stream(result).map(list -> list.stream().mapToInt(Integer::valueOf).toArray()).toArray(int[][]::new);
        return ints;
    }

    public static void forRecursion(TreeNode node,List<Integer>[] result){
        if(node == null){
            return;
        }
        // 前序
        result[0].add(node.val);
        forRecursion(node.left,result);
        // 中序
        result[1].add(node.val);
        forRecursion(node.right,result);
        // 后序
        result[2].add(node.val);
    }
}
