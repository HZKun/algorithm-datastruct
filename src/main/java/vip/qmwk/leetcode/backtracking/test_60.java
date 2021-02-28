package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class test_60 {

    /**
     * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * 输入：n = 3, k = 3
     * 输出："213"
     *
     * @param n
     * @param k
     * @return
     */
    static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static String getPermutation(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        used[0] = true;
        dfs(result, path, n, k, used, 0);
        List<Integer> list = result.get(result.size() - 1);
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            s.append(list.get(i).toString());
        }
        return s.toString();
    }

    private static void dfs(List<List<Integer>> result, List<Integer> path, int n, int k, boolean[] used, int depth) {
        if (result.size() == k) {
            return;
        }
        int temp = factorial[n - depth - 1];
        for (int i = 1; i <= n; i++) {
            if(used[i]){
                continue;
            }
            if(k > temp){
                k -= temp;
                continue;
            }
            path.add(i);
            used[i] = true;
            dfs(result, path, n, k, used, depth + 1);
            return;

        }
    }

    public static void main(String[] args) {
        String s = getPermutation(3, 2);
        System.out.println(s);
    }

}
