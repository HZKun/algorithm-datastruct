package vip.qmwk.leetcode.hot100_1;


import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 输入：s = "()(())"
 * 输出：6
 *
 */
public class Test_32_todo {

    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("))())()()(()"));
    }

}
