package vip.qmwk.leetcode.interview;

/**
 * 从左下或右上开始移动(横纵遍历一个增一个减)，每次可排除一行或一列
 */
public class Test_3 {

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        if (matrix[0][0] == target) {
            return true;
        }
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (matrix[i][i] == target) {
                return true;
            } else if (matrix[i][i] > target) {
                for (int j = 0; j < i; j++) {
                    if (matrix[j][i] == target || matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        if (m > n) {
            for (int i = num; i < m; i++) {
                if (matrix[i][n - 1] == target) {
                    return true;
                } else if (matrix[i][n - 1] > target) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == target) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = num; i < n; i++) {
                if (matrix[m - 1][i] == target) {
                    return true;
                } else if (matrix[m - 1][i] > target) {
                    for (int j = 0; j < m; j++) {
                        if (matrix[j][i] == target) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{-1, 3}};
        System.out.println(searchMatrix(arr, 3));

    }
}
