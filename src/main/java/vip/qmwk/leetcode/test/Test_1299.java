package vip.qmwk.leetcode.test;
import java.util.Arrays;

public class Test_1299
{


    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                arr[i] = -1;
            }else{
                arr[i] = getArrMax(Arrays.copyOfRange(arr,i + 1,arr.length));
            }
        }
        return arr;
    }

    /**
     * 獲取数组中最大值
     * @param arr
     * @return
     */
    private static int getArrMax(int[] arr){
        int max = arr[0];
        if(arr.length == 1){
            return max;
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
