package vip.qmwk.leetcode.recodeOne;

/**
 * 最长回文子串
 *
 * @Auther: HZK
 * @Date: 2020/08/31/11:11
 * @Description:
 */
public class Test_5 {

    public static String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int length1 = expandStr(s,i,i);
            int length2 = expandStr(s,i,i+1);
            int length = Math.max(length1,length2);
            if(length > end - start){
                start = i - (length-1)/2;
                end = i + length/2;
            }
        }
        return s.substring(start,end + 1);
    }

    /**
     * 扩展回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int expandStr(String s, int left, int right){
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 最后-2是因为当left = right时，会left--,right++导致不一致，所以要把这个--++减掉
        return right - left + 1 -2;
    }
}
