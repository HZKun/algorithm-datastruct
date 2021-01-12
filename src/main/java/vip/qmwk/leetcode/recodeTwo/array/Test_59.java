package vip.qmwk.leetcode.recodeTwo.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/12/20:06
 * @Description:
 */
public class Test_59 {

    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        // 填充的数字
        int num = 1;
        // 上边界
        int top = 0;
        // 右边界
        int right = n-1;
        // 下边界
        int bottom = n-1;
        // 左边界
        int left = 0;
        while(num <= n * n){
            // 从左上到右上
            for(int i = left;i<=right;i++){
                arr[top][i] = num++;
            }
            top++;
            // 从右上到右下
            for(int i = top;i<=bottom;i++){
                arr[i][right] = num++;
            }
            right--;
            // 右下到左下
            for(int i = right;i>=left;i--){
                arr[bottom][i] = num++;
            }
            bottom--;
            // 左下到左上
            for(int i = bottom;i>=top;i--){
                arr[i][left] = num++;
            }
            left++;
        }
        return arr;
    }
}
