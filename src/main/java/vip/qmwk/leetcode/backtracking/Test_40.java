package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_40 {

    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result,path,candidates,0,target);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> path, int[] arr, int index, int target){
        // 终止条件
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i<arr.length;i++){
            if(target - arr[i] < 0){
                return;
            }
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            path.add(arr[i]);
            target -= arr[i];
            System.out.println("递归之前 => " + path + "，剩余 = " + target);

            dfs(result,path,arr,i + 1,target);

            target += arr[i];
            path.remove(path.size() - 1);
            System.out.println("递归之后 => " + path + "，剩余 = " + target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(arr, 8);
        System.out.println(lists);
    }
}
