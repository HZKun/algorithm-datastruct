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
public class Test_32 {



    public static int longestValidParentheses(String s) {
        if(s.length() <= 1){
            return 0;
        }
        int maxLen1 = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                temp = left*2;
            }else if(right > left){
                left = 0;
                right = 0;
                temp = 0;
            }
            maxLen1 = Math.max(maxLen1,temp);
        }
        int maxLen2 = 0;
        left = 0;
        right = 0;
        temp = 0;
        for(int i = s.length() - 1;i>=0;i--){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                temp = left*2;
            }else if(right < left){
                left = 0;
                right = 0;
                temp = 0;
            }
            maxLen2 = Math.max(maxLen2,temp);
        }
        return Math.max(maxLen1,maxLen2);
    }


    public static int longestValidParentheses1(String s) {
        if(s.length() <= 1){
            return 0;
        }
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                Integer index = stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                maxLen = Math.max(maxLen,i - stack.peek());
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "()(())";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
}
