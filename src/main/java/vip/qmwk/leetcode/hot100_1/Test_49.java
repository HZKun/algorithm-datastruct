package vip.qmwk.leetcode.hot100_1;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */
public class Test_49 {

    /**
     * 直接获取字符数组排序，一致的为一组
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            byte[] bytes = str.getBytes();
            Arrays.sort(bytes);
            String temp = new String(bytes);
            if (map.containsKey(temp)) {
                List<String> tempResult = map.get(temp);
                tempResult.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(s);
        System.out.println(lists);
//        System.out.println(isEqual("tan","nat"));

    }



}
