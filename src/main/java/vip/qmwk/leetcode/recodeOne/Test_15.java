package vip.qmwk.leetcode.recodeOne;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/10/09/10:20
 * @Description:
 */
public class Test_15 {

    public static void main(String[] args) {
        int[] nums = {1,2,-2,-1};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 2){
            return result;
        }
        Arrays.sort(nums);
        // 首指针
        for (int i = 0; i < nums.length-1; i++) {
            if(i >= 1 && nums[i] == nums[i -1]) {
                continue;
            }
            // 尾指针
            int last = nums.length - 1;
            // 中间值
            for (int j = i + 1; j < nums.length; j++) {
                if(j >= i+2 && nums[j] == nums[j-1]){
                    continue;
                }
                while(j<last && nums[i] + nums[j] + nums[last] > 0){
                    last--;
                }
                if(j == last){
                    break;
                }
                if(nums[i] + nums[j] + nums[last] == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[last]);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
