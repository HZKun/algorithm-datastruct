package vip.qmwk.leetcode.hot100_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2-abc,3-def,4-ghi,5-jkl,6-mno,7-pqrs,8-tuv,9wxyz
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 输入：digits = ""
 * 输出：[]
 * digits = "2"
 * 输出：["a","b","c"]
 *
 */
public class Test_17 {

    private static Map<Integer,String> map = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        StringBuilder sb = new StringBuilder();
        dfs(result,digits,0,sb);
        return result;
    }

    private static void dfs(List<String> result, String digits, int index, StringBuilder sb){
        // 终止条件
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        Integer num = Integer.valueOf(digits.substring(index, index + 1));
        String s = map.get(num);
        for(int j = 0;j<s.length();j++){
            sb.append(s.substring(j,j+1));
            dfs(result, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        String digits = "2";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);
    }
}
