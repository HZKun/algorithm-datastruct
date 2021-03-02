package vip.qmwk.leetcode.hot100;

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
        int length = 0;
        int leftIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                int index = map.get(s.charAt(i));
                // 左指针变为index位置
                leftIndex = Math.max(leftIndex, index + 1);
            }
            length = Math.max(length, i - leftIndex + 1);
            map.put(s.charAt(i), i);
        }
        return length;
    }


    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
