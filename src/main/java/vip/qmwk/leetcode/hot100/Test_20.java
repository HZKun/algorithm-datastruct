package vip.qmwk.leetcode.hot100;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 输入：s = "()[]{}"
 * 输出：true
 * 输入：s = "{[]}"
 * 输出：true
 * 输入：s = "([)]"
 * 输出：false
 *
 */
public class Test_20 {

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            String temp = s.substring(i,i+1);
            if(temp.equals("(") || temp.equals("{") || temp.equals("[")){
                stack.push(temp);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                String pop = stack.pop();
                if((temp.equals(")") && pop.equals("(")) || (temp.equals("}") && pop.equals("{")) || (temp.equals("]") && pop.equals("["))){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
