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
public class Test_32_toImprove {

    public static int longestValidParentheses(String s) {
        if(s.length() <= 1){
            return 0;
        }
        int maxLen = 0;
        int temp = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                Integer index = stack.pop();
                if(index == -1 || s.charAt(index) == ')'){
                    stack.push(i);
                }else{
                    temp = i - stack.peek();
                }
            }
            maxLen = Math.max(maxLen,temp);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "(()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
}
