package vip.qmwk.leetcode.hot100_1;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案
 * 输入：s = "cbbd"
 * 输出："bb"
 * 输入：s = "ac"
 * 输出："a"
 */
public class Test_5 {

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 1){
            return s;
        }
        int length = s.length();
        // 如果dp[i][j]为回文串，当s.charAt(i - 1) = s.chatAt(j + 1),则dp[i-1][j+1]也是回文串
        boolean dp[][] = new boolean[length + 1][length + 1];
        // 初始化，长度为0回文串
        for(int i = 0;i<length;i++){
            dp[i][i] = true;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        // 回文串从1开始到s.length，循环查找最大值
        for(int l = 1;l<=length;l++){
            // i为回文串左边界索引，j为回文串右边界索引
            for(int i = 0;i + l <=length;i++){
                int j = i + l - 1;
                if(l == 1){
                    //长度为1回文串
                    dp[i][j] = true;
                    continue;
                }
                // 长度大于1
                if(s.charAt(i) == s.charAt(j)){
                    if(l == 2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    if(l > rightIndex - leftIndex + 1){
                        leftIndex = i;
                        rightIndex = j;
                    }
                }
            }
        }
        return s.substring(leftIndex,rightIndex + 1);
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));
    }
}
