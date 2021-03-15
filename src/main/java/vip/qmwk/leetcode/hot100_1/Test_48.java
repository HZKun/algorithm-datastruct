package vip.qmwk.leetcode.hot100_1;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 */
public class Test_48 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 1){
            return;
        }
        rotate(0,matrix,n);
    }

    private static void rotate(int index, int[][] matrix, int length){
        if(length <= 1){
            return;
        }
        int[] temp = new int[length];
        for(int i = 0;i<length - 1;i++){
            // 上放入临时数组中
            temp[i] = matrix[index][index + i];
            // 左边放入上
            matrix[index][index + i] = matrix[index + length - 1 - i][index];
            // 下放左
            matrix[index + length - 1 - i][index] = matrix[index + length - 1][index + length - 1 - i];
            // 右放下
            matrix[index + length - 1][index + length - 1 - i] = matrix[index + i][index + length - 1];
            // 临时放右
            matrix[index + i][index + length - 1] = temp[i];
        }
        rotate(index + 1,matrix,length - 2);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
    }

}
