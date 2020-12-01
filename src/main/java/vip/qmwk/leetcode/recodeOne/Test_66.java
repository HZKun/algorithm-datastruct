package vip.qmwk.leetcode.recodeOne;

import java.util.Arrays;

/**
 * @author hzk
 * @Description: 加一
 * @date 2020/11/1 21:59
 */
public class Test_66 {

    public static void main(String[] args) {
        int[] nums = {0};
        int[] result = plusOne(nums);
        for (int i = 0;i<result.length; i++) {
            System.out.println(result[i]);
        }
    }




    public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return null;
        }
        boolean add = false;
        for(int i = digits.length - 1; i >= 0; i--){
            if(i != digits.length - 1 && !add){
                return digits;
            }
            int num = digits[i];
            if(num + 1 >9){
                digits[i] = 0;
                add = true;
            }else{
                digits[i] = num + 1;
                add = false;
            }
            if(i == 0 && add && digits[i] == 0){
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
        }
        return digits;
    }
}
