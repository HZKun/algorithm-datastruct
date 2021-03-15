package vip.qmwk.leetcode.hot100_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 输入：n = 1
 * 输出：["()"]
 */
public class Test_22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(result,sb,n,0,0);
        return result;
    }

    private static void dfs(List<String> result,StringBuilder sb,int n,int leftNum,int rightNum){
        if(sb.length() == n * 2){
            result.add(sb.toString());
            return;
        }
        if(leftNum < n){
            sb.append("(");
            dfs(result, sb, n, leftNum + 1, rightNum);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(rightNum < leftNum){
            sb.append(")");
            dfs(result, sb, n, leftNum , rightNum + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

}
