package vip.qmwk.leetcode.recodeTwo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/13/15:02
 * @Description:
 */
public class Test_1 {

    public static void main(String[] args) {
        int[] arr = {3,3};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int num1 = nums[i];
            if(map.containsKey(num1)){
                result[0] = map.get(num1);
                result[1] = i;
                return result;
            }else{
                map.put(target-num1,i);
            }
        }
        return result;
    }
}
