package vip.qmwk.leetcode.hot100_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class Test_39 {

    private int count;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result,path,candidates,target, 0);
        return result;
    }


    private static void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int index){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index;i<candidates.length;i++){
            target -= candidates[i];
            if(target < 0){
                target += candidates[i];
                return;
            }
            path.add(candidates[i]);
            dfs(result, path, candidates, target, index);
            path.remove(path.size() - 1);
            target += candidates[i];
            index++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,7,6,3,5,1};
        List<List<Integer>> lists = combinationSum(arr, 9);
        System.out.println(lists);
    }
}
