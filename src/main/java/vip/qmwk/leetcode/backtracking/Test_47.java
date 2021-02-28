package vip.qmwk.leetcode.backtracking;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Test_47 {


    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<String> contains = new ArrayList<>();
        dfs(result, nums, 0, path, used, contains);
        return result;
    }

    /**
     * dfs
     * @param result
     * @param nums
     * @param depth
     * @param path
     * @param used
     * @param contains
     */
    private static void dfs(List<List<Integer>> result, int[] nums, int depth, List<Integer> path, boolean[] used, List<String> contains){
        // 终止条件
        if(depth == nums.length){
            StringBuilder s = new StringBuilder();
            for(int i = 0;i<path.size();i++){
                s.append(path.get(i));
                if(i != path.size() - 1){
                    s.append(",");
                }
            }
            if(!contains.contains(s.toString())){
                contains.add(s.toString());
                result.add(new ArrayList<>(path));
            }
        }

        for(int i = 0;i<nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;

                dfs(result, nums, depth + 1, path, used, contains);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        List<List<Integer>> result = permuteUnique(arr);
        System.out.println(result);
    }
}
