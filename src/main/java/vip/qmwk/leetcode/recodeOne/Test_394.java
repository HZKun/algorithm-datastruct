package vip.qmwk.leetcode.recodeOne;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/09/11:08
 * @Description:
 */
public class Test_394 {

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        Stack<String> stack = new Stack<> ();
        String tmpNum = null;
        String tmpStr = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != ']'){
                if(c >= '0' && c <= '9'){
                    tmpNum = tmpNum == null ? String.valueOf(c): (tmpNum+ c);
                }else{
                    // 先把数字入栈
                    if(tmpNum != null){
                        stack.push(tmpNum);
                        tmpNum = null;
                    }
                    // 再把字母或者'['入栈
                    stack.push(String.valueOf(c));
                }
            }else{
                // 当前字符为] 出栈,直到最近一个[出栈
                while (!"[".equals(stack.peek())) {
                    String pop = stack.pop();
                    tmpStr = tmpStr == null ? String.valueOf(pop): (tmpStr + pop);;
                }
                // 走到此处说明当前栈顶为[字符，获取到[前一个数字
                stack.pop();
                String num = stack.pop();
                for (int j = 0; j < Integer.parseInt(num); j++) {
                    // 将tmpStr入栈num次
                    stack.push(tmpStr);
                }
                tmpStr = null;
            }
        }
        // 最后把整个栈去除即为字符串
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
