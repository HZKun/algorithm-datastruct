package vip.qmwk.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Test_46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(result,path,nums,used);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> path,int[] nums, boolean[] used){
        // 终止条件
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(result, path, nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> result = permute(arr);
        System.out.println(result);
    }
}
