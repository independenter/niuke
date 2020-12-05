package year2020.month12.day05;

import cn.hutool.core.lang.Console;

/**
 * <p> 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * <code>
 *     input: [[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
 *     output: 12
 * </code>
 * <analysis>
 *     通过画图,我们采用动态规划,将上一次结果缓存到当前结果行 时间复杂度为O(nm)
 * </analysis>
 *
 * @author independenter
 * @since
 */
public class Solution6 {

    private static int[][] input = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};

    public static void main(String[] args) {
        Console.log(new Solution6().minPathSum(input));
    }

    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        // write code here
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dPath = new int[row][col];
        dPath[0][0] = matrix[0][0];
//        for (int i = 1; i < row; i++) {
//            dPath[i][0] = dPath[i-1][0] + matrix[i][0];
//        }
        for (int i = 1; i < col; i++) {
            dPath[0][i] = dPath[0][i-1] + matrix[0][i];
        }
        for (int i=1;i<row;i++){
            //dPath[i][0] = dPath[i-1][0] + matrix[i][0];
            for (int j=1;j<col;j++){
                dPath[i][j] = Math.min(dPath[i-1][j],dPath[i][j-1]) + matrix[i][j];
            }
        }
        return dPath[row-1][col-1];
    }
}
