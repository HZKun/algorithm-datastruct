package vip.qmwk.leetcode.hot100_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Test_3 {

    public static int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.get(c) != null){
                // 获取该字符已出现的坐标
                int index = map.get(c);
                // 此时去除重复字符后，子串应该从index+1开始算,因为当前字符入窗口了
                // 由于index可能为之前坐标字符，所以子串为最右的坐标。
                // 如abba。最后一个a时，index为第一个a的坐标。但是子串为从第二个b开始
                begin = Math.max(begin, index + 1);
            }
            maxLen = Math.max(maxLen, i - begin + 1);
            map.put(c, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
