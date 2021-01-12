package vip.qmwk.leetcode.recodeTwo.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/12/20:06
 * @Description:
 */
public class Test_59 {

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[][];
        for(int i = 1;i<=n*n;i++){
            if(i<=n){
                arr[0][i-1] = i;
            }else if(i<=2*n-1){
                arr[n-1][i-n-1] = i;
            }else if(i<=){

            }
        }
    }

    private void putValueForCircle(int[][] arr, int begin,int num){

    }
}
