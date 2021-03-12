package vip.qmwk.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
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

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        addResult(result, Arrays.asList(strs));
        return result;
    }

    private static void addResult(List<List<String>> result, List<String> strs){
        if(strs.size() == 0){
            return;
        }
        List<String> tempResult = new ArrayList<>();
        tempResult.add(strs.get(0));
        if(strs.size() == 1){
            result.add(tempResult);
            return;
        }
        List<String> last = new ArrayList<>();
        String str = strs.get(0);
        for(int i = 1;i<strs.size();i++){
            if(isEqual(str,strs.get(i))){
                tempResult.add(strs.get(i));
            }else{
                last.add(strs.get(i));
            }
        }
        result.add(tempResult);
        addResult(result, last);
    }

    private static boolean isEqual(String s1, String s2){
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        for(int i = 0;i<s1.length();i++){
            char c = s1.charAt(i);
            int j = s2.indexOf(c);
            if(j == -1){
                return false;
            }
            if(j == s2.length()){
                s2 = s2.substring(0,j);
            }else{
                s2 = s2.substring(0,j) + s2.substring(j + 1);
            }
        }
        return s2.length() == 0;
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(s);
        System.out.println(lists);
//        System.out.println(isEqual("tan","nat"));

    }
}
