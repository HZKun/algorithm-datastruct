package vip.qmwk.leetcode.recodeOne;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/02/10:50
 * @Description:
 */
public class Test_28 {

    public static void main(String[] args) {
        String a = "aaab";
        String b = "abb";
        System.out.println(strStr(a,b));
    }

    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        char first = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            if(c == first){
                if((haystack.length() - i) < needle.length()){
                    return -1;
                }else {
                    String substring = haystack.substring(i, i + needle.length());
                    if(substring.equals(needle)){
                        return i;
                    }
                }

            }
        }
        return -1;
    }
}
