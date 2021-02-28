package vip.qmwk.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 投票算法
 * 分治算法
 *
 */
public class Test_2 {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                if((++count) > (nums.length / 2)){
                    return nums[i];
                }
                map.put(nums[i], count);
            }else{
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {6,5,5};
        System.out.println(majorityElement(arr));
    }
}
