package vip.qmwk.leetcode.hot100;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class Test_48 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1){
            return;
        }
        rotateMatrix(matrix,0,n);
    }

    private static void rotateMatrix(int[][] matrix, int begin,int length){
        if(length <= 1){
            return;
        }
        int[] temp = new int[length];
        for(int i = 0;i<length - 1;i++){
            // 上保存入临时数组
            temp[i] = matrix[begin][i + begin];
            // 左变上
            matrix[begin][i + begin] = matrix[begin + length - 1 - i][begin];
            // 下变左
            matrix[begin + length - 1 - i][begin] = matrix[begin + length - 1][begin + length - 1 - i];
            // 右变下
            matrix[begin + length - 1][begin + length - 1 - i] = matrix[i + begin][begin + length - 1];
            // 临时变右
            matrix[i + begin][begin + length - 1] = temp[i];
        }
        rotateMatrix(matrix,begin + 1,length - 2);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
    }
}
