package vip.qmwk.leetcode.hot100;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 */
public class Test_72 {

    public static int minDistance(String word1, String word2) {
        if(word1.length() == 0 && word2.length() == 0){
            return 0;
        }
        int l1 = word1.length();
        int l2 = word2.length();
        // dp[i][j]为A的前i个字符与B的前j个字符操作的最小数
        int[][] dp = new int[l1 + 1][l2 + 1];
        for(int i = 0;i<=l1;i++){
            dp[i][0] = i;
        }
        for(int i = 0;i<=l2;i++){
            dp[0][i] = i;
        }
        for(int i = 1;i<=l1;i++){
            for(int j = 1;j<=l2;j++){
                dp[i][j] = Math.min((dp[i - 1][j] + 1),dp[i][j-1] + 1);
                if(i<=l1 && j<=l2 && word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
}
