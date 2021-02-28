package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test_78_1_not {

    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length ==0){
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        process(list, nums, 0);
        return lists;

    }

    private static void process(List<Integer>list, int[] nums, int start){
        lists.add(new ArrayList(list));
        for(int i = start; i < nums.length; i++){

            list.add(nums[i]);
            process(list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List<List<Integer>> subsets = subsets(arr);
        System.out.println(subsets);
    }


}
