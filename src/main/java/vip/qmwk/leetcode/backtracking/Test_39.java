package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_39 {


    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, path, candidates, target, 0);
        return result;

    }

    private static void dfs(List<List<Integer>> result, List<Integer> path, int[] arr, int target, int index){
        // 终止条件
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = index;i<arr.length;i++){
            if(target - arr[i] < 0){
                return;
            }

            path.add(arr[i]);
            target -= arr[i];

            dfs(result, path, arr, target, i);

            target += arr[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5};
        List<List<Integer>> lists = combinationSum(arr, 8);
        System.out.println(lists);
    }

}
