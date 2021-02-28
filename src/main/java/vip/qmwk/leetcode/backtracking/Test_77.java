package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test_77 {


    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, n, k, 1);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> path, int n, int k, int index){
        // 终止条件
        if(k == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i<=n - k + 1;i++){
            path.add(i);

            dfs(result, path, n, k-1, i + 1);

            path.remove(path.size() - 1);
            index++;

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}
