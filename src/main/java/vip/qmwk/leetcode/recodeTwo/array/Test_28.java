package vip.qmwk.leetcode.recodeTwo.array;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 *
 * @Auther: HZK
 * @Date: 2021/01/12/10:19
 * @Description:
 */
public class Test_28 {

    public static void main(String[] args) {
        String s1 = "aaaaa";
        String s2 = "aa";
        System.out.println(strStr(s1,s2));
    }

    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }
        int l1 = haystack.length();
        int l2 = needle.length();
        for(int i = 0;i<=l1-l2;i++){
            String substring = haystack.substring(i, i+l2);
            if(substring.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
