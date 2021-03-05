package vip.qmwk.leetcode.hot100_1;

import java.util.HashMap;
import java.util.Map;

public class Test_1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.get(nums[i]) != null){
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }else{
                map.put(target - nums[i],i);
            }
        }
        return result;
    }
}
