package vip.qmwk.leetcode.interview;

import java.util.regex.Pattern;

public class Test_6 {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        s = s.toLowerCase();
        int length = s.length();
        int begin = 0;
        int last = length - 1;
        while(begin < last){
            while(!Character.isLetterOrDigit(s.charAt(begin))){
                begin++;
                if(begin >= last){
                    return true;
                }
            }
            while(!Character.isLetterOrDigit(s.charAt(last))){
                last--;
                if(last < begin){
                    return true;
                }
            }
            if(begin > last){
                return false;
            }
            if(s.charAt(begin) != s.charAt(last)){
                return false;
            }
            begin++;
            last--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "\"Sue,\" Tom smiles, \"Selim smote us.\"";
        System.out.println(isPalindrome(s));
    }
}
