package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test_46 {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
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
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(result, nums,path,0,used);
        return result;
    }

    /**
     * dfs回溯
     * @param nums
     * @param path
     * @param depth
     * @param used
     */
    private static void dfs(List<List<Integer>> result, int[] nums, List<Integer> path, int depth, boolean[] used){
        // 设置递归的终止条件
        if(depth == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        // 非叶子节点处，开始走路线
        for(int i = 0;i<nums.length;i++){
            // 向下走路线
            if(!used[i]){
                // 取第一个值
                path.add(nums[i]);
                used[i] = true;
                // 剩下的值继续回溯
                dfs(result, nums, path, depth + 1,used);
                // 回溯完原路返回
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> result = permute(arr);
        System.out.println(result);
    }

}
