package vip.qmwk.leetcode.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test_167
{


    public static void main(String[] args) {
        int[] nums = {-1,0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> tempMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(tempMap.containsKey(numbers[i])){
                int next = tempMap.get(numbers[i]);
                return next > i ? new int[] {i + 1, next + 1}:new int[] {next + 1, i + 1};
            }else{
                tempMap.put(target - numbers[i],i);
            }
        }
        return null;
    }
}
