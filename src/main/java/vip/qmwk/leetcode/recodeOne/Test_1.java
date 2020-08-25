package vip.qmwk.leetcode.recodeOne;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和.
 *
 * @Auther: HZK
 * @Date: 2020/08/24/17:47
 * @Description:
 */
public class Test_1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int result = target - curr;
            if(map.containsKey(result)){
                Integer resultIndex = map.get(result);
                return new int[]{resultIndex,i};
            }else{
                map.put(curr,i);
            }
        }
        return null;
    }
}
