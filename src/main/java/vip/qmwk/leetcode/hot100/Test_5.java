package vip.qmwk.leetcode.hot100;

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
        int n = s.length();
        // 特例
        if(s.length() <= 1){
            return s;
        }
        boolean[][] dp = new boolean[n + 1][n + 1];
        String result = "";

        // i 为回文串长度
        for(int i = 0;i<=n;i++){
            // j 为回文串起始位置坐标,则j+i <= n
            for(int j = 0; j + i <= n;j++){
                // 回文串结尾位置为k，不包括k(例，当i = 1时，dp[j][k]应该相差1，而不是0。否则当i=0,dp[][]无法表示)，即字符串的k-1的索引
                // 即k-j=i，为回文串长度
                int k = j + i;
                if(i == 0){
                    // 字符串为空,是回文串长度为0的情况,则k回文串结尾置j
                    k = j;
                    // 长度为n,j为索引最多到n-1
                    if(j == n){
                        continue;
                    }
                    dp[j][k] = true;
                }else if(i == 1){
                    dp[j][k] = true;
                }else{
                    dp[j][k] = dp[j + 1][k - 1] && s.charAt(j) == s.charAt(k-1);
                }
                // 取dp[][]为true的最大值
                if(dp[j][k] && i > result.length()){
                    result = s.substring(j,k);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ac";
        System.out.println(longestPalindrome(s));
    }
}
