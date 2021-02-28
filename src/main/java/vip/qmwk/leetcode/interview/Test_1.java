package vip.qmwk.leetcode.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 任何数异或本身=0
 */
public class Test_1 {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int key = nums[i];
            if(map.containsKey(key)){
                map.remove(key);
            }else{
                map.put(key, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            return entry.getKey();
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(singleNumber(arr));
    }
}
