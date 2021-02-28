package vip.qmwk.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class Test_5 {

    /**
     *你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
     * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
     * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
     * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
     * 你的目标是确切地知道 F 的值是多少。
     * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
     * @param K
     * @param N
     * @return
     */
    private static int[][] resultArr = null;

    public static int superEggDrop(int K, int N) {
        resultArr = new int[K+1][N+1];
        return dp(K,N);
    }

    public static int dp(int K, int N) {

        // 楼层为0，都是0，已经初始化了
        // 楼层为1，则只需要1次就知道
        if(N == 0){
            return 0;
        }
        if(N == 1){
            return 1;
        }
        // 鸡蛋只有一个的情况，有几层楼就得几次(考虑最坏的情况)
        if(K == 1){
            return N;
        }
        Integer key = N * 1000 + K;
        if (resultArr[K][N] != 0)
            return resultArr[K][N];
        //开始状态转移方程
        // 当楼层为X时，有两种情况，碎的时候则得鸡蛋少一，楼层少一(少了当前层),即dp(k-1,x-1)，鸡蛋没碎，则鸡蛋不变，楼层在X之上,即dp(k,n-x)，因此结果为这两种情况取最小值
        // dp(K,N) = 1 + min{max{dp(k-1,x-1),max{k,n-x}}}

        // 对应的次数,即最坏的情况，K<=100

        // 当x楼层从1~N开始遍历时，查找出对应的result，取最小值即可

        //        for(int x = 2;x<=N;x++){
        //           本次循环值为temp
        //           则temp = 1 +  max(dp(K - 1, i - 1), dp(K, N - i))
        //        }
        //        获取最小的temp

        // 考虑到对于dp(K-1, i-1)随着i增加(类比dp(K,N),N越大，结果必然越大)，最后得到的temp必然也是递增的
        // 对于dp(k,n-i)随着i增加，最后得到的temp递减
        // 则上面for循环最小值必为两条直线的交点，即山谷图像，那么就是快速找到交点即山谷点
        // 即抽象为x从1~N，temp从大变小变大。把x想象为数组索引，即寻找数组(先递减后递增)的最小值，可用二分法快速查找最小值(最小值满足小于左一，小于右一)
        int begin = 1;
        int end = N;
        //int result = Integer.MAX_VALUE;
        while(begin < end){
            // 二分法找值，此处mid即为二分的x索引
            int mid = (begin + end)/2;
            int breakn = dp(K-1,mid-1);
            int notBreakn = dp(K,N-mid);
            if(breakn > notBreakn){
                end = mid - 1;
                //result = Math.min(result, breakn + 1);
            }else if(breakn < notBreakn){
                // 即找的这个中点左比右小，在交点的左边(递增的函数小于递减的函数)
                begin = mid + 1;
                //result = Math.min(result, notBreakn + 1);
            }else{
                begin = end = mid;
            }

        }
        int result = 1 + Math.min(
                Math.max(dp(K - 1, begin - 1), dp(K, N - begin)),
                Math.max(dp(K - 1, end - 1), dp(K, N - end))
        );
        resultArr[K][N] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(3,25));
    }
}
