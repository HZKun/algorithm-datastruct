package vip.qmwk.leetcode.hot100_1;

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
 */
public class Test_72 {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        // 初始化
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i = 0;i<=m;i++){
            dp[i][0] = i;
        }
        for(int i = 0;i<=n;i++){
            dp[0][i] = i;
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int temp = Math.min(dp[i][j-1],dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i-1][j-1],temp) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
}
