package vip.qmwk.leetcode.recodeOne;

/**
 * 正则表达式匹配.
 *
 * @Auther: HZK
 * @Date: 2020/09/02/16:41
 * @Description:
 */
public class Test_10 {

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        /**
         * s的前i个字符能否匹配p前j个字符
         * 状态转移方程
         *              dp[i-1][j-1],p[j]为字符或者.
         * dp[i][j] =   dp[i][j-2],p[j]为*且代表0个字符
         *              dp[i-1][j],p[j]为*且代表1到多个字符
         */
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始化
        dp[0][0] = true;
        // 初始化第一行，没必要初始化第一列，因为p为空则必为false(boolean的默认值，故只要初始化为true的情况)
        for (int i = 2; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        // 填写dp[][]剩余部分
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char nows = s.charAt(i - 1);
                char nowp = p.charAt(j - 1);
                if (nows == nowp) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (nowp == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (nowp == '*') {
                        //p需要能前移1个。（当前p指向的是j-1，前移1位就是j-2，因此为j>=2）
                        if (j >= 2) {
                            char nowpLast = p.charAt(j - 2);
                            //只有p[j-2]==s[i-1]或p[j-2]==‘.’才可以让*取1个或者多个字符：
                            if (nowpLast == nows || nowpLast == '.')
                                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                            //不论p[j-2]是否等于s[i-1]都可以删除掉j-1和j-2处字符：
                            //匹配0个
                            dp[i][j] = dp[i][j] || dp[i][j - 2];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
