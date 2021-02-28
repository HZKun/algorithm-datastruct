package vip.qmwk.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test_93 {

    /**
     * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
     *
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * @param s
     * @return
     */
    static StringBuilder str = new StringBuilder();

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) {
            return result;
        }
//        if(s.length() == 4){
//            for(int i = 0;i<s.length();i++){
//                str.append(s.charAt(i));
//                if(i != s.length() - 1){
//                    str.append(".");
//                }
//            }
//            result.add(str.toString());
//            return result;
//        }
        dfs(result,s,3);
        return result;
    }

    private static void dfs(List<String> result, String s, int depth){
        if(depth < 0){
            result.add(str.substring(0,str.length() - 1));
            return;
        }

        // i为当前区间的长度
        for(int i = 1;i<=3;i++){
            // 每个间隔最多为3
            if((s.length() - i) > depth * 3){
                continue;
            }
            if(i > s.length()){
                return;
            }
            String temp = s.substring(0,i);
            if((i > 1 && temp.startsWith("0")) || (i == 3 && Integer.parseInt(temp) > 255)){
                continue;
            }
            s = s.substring(i);
            str.append(temp).append(".");
            dfs(result, s, depth - 1);
            s  = temp + s;
            str.delete(str.length() - i - 1, str.length());
        }
    }

    public static void main(String[] args) {
        String s = "0000";
        List<String> list = restoreIpAddresses(s);
        System.out.println(list);
    }
}
