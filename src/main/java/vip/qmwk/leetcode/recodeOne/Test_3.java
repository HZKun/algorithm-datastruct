package vip.qmwk.leetcode.recodeOne;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hzk
 * @Description: 无重复字符的最长子串
 * @date 2020/8/25 23:32
 */
public class Test_3 {

    String s = "dvdf";

    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int count = 0;
        if(s == null){
            return maxCount;
        }
        if(s.equals("")){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i<s.length(); i++) {
              if(map.containsKey(s.charAt(i))){
                  maxCount = Math.max(maxCount, count);
                  int index = map.get(s.charAt(i));
                  map.clear();
                  i = index;
                  count = 0;
              }else{
                  map.put(s.charAt(i), i);
                  count++;
              }
        }
        return Math.max(maxCount, count);
    }
}
