package vip.qmwk.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class Test_76 {

    private static Map<Character, Integer> map = new HashMap<>();

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 封装所需的所有t的字符及个数
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                Integer num = map.get(t.charAt(i));
                map.put(t.charAt(i), num+1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        // 定义结果的左右索引
        int minLen = s.length() + 1;
        int resultLeft = 0;
        int resultRight = 0;
        // 循环s直到left~right包括了所有的t字符
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                Integer num = map.get(ch);
                map.put(ch,num-1);
            }
            // 如果当前包括了所有的关键字符，则移动左索引
            while(check() && left <= right){
                if(right - left + 1 < minLen){
                    resultLeft = left;
                    resultRight = right;
                    minLen = right - left + 1;
                }
                // 去除左边第一个关键字
                char leftCh = s.charAt(left);
                if(map.containsKey(leftCh)){
                    Integer num = map.get(leftCh);
                    map.put(leftCh,num+1);
                }
                left++;
            }
            right++;
        }
        if(minLen < s.length() + 1){
            return s.substring(resultLeft,resultRight + 1);
        }
        return "";
    }

    private static boolean check(){
        boolean check = true;
        for(Integer num: map.values()){
            if(num > 0){
                check = false;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("AA","AA"));
    }
}
