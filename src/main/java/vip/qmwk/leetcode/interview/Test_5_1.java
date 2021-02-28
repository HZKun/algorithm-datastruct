package vip.qmwk.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class Test_5_1 {

    private static int[][] resultArr = null;


    public static int superEggDrop(int K, int N) {
        resultArr = new int[K+1][N+1];
        return dp(K,N);
    }

    private static int dp(int K, int N){
        if(K == 1){
            return N;
        }
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }
        if (resultArr[K][N] != 0)
            return resultArr[K][N];
        int begin = 1;
        int end = N;
        int result = Integer.MAX_VALUE;
        while(begin <= end){    // TODO 没写=就报错
            int mid = begin + (end - begin)/2 ;
            int broken = dp(K-1, mid-1);
            int notBroken = dp(K, N-mid);
            if(broken > notBroken){
                end = mid - 1;
                result = Math.min(result, (broken + 1));
            }else{
                begin = mid + 1;
                result = Math.min(result, (notBroken + 1));
            }
        }
        resultArr[K][N] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(3,25));
    }
}
