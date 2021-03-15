package vip.qmwk.leetcode.hot100_1;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 */
public class Test_42 {

    /**
     * 动态规划
     * 对于当前元素i，i所能接住的雨水数量为：i向左边的最大值，与i向右边的最大值。两者的最小值减去当前i的值
     * 从左到右遍历的left，对于dp[left]，左边最大值为dp[left - 1]与height[left]的最大值。而右边最大值未知。
     * 从右到左遍历的right，对于dp[right],右边最大值为dp[right + 1]与height[right]的最大值，而左边未知。
     * 当left<right时，则从左向右循环，左边最大值已知，右边最大值>=right的右边最大值。右边同理。
     * 则当左边最大值<右边可见的最大值时，可不需要知道右边最大值具体指变可计算水的量(因为取左右的较小值)
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        int sum = 0;
        int left = 1;
        int right = height.length - 2;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while(left <= right){
            // 当前左边最大值为
            leftMax = Math.max(leftMax, height[left-1]);
            // 当前右边最大值为
            rightMax = Math.max(rightMax, height[right + 1]);
            if(leftMax < rightMax){
                // 当前left坐标可接水为
                if(leftMax > height[left]){
                    sum += leftMax - height[left];
                }
                left++;
            }else{
                // 当前right可接水为
                if(rightMax > height[right]){
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }


    /**
     * 动态规划---第一印象
     * 对于当前元素i，i所能接住的雨水数量为：i向左边的最大值，与i向右边的最大值。两者的最小值减去当前i的值
     * 对于dp[i]，左边最大值为dp[i - 1]与height[i]的最大值。而右边最大值未知。因此代码如下
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        int sum = 0;
        int leftMax = 0;
        int[] leftMaxDp = new int[height.length];
        leftMaxDp[0] = 0;
        for(int i = 1;i<height.length;i++){
            // 左侧最大值
            leftMax = Math.max(leftMaxDp[i - 1],height[i-1]);
            leftMaxDp[i] = leftMax;
            // 右侧最大值
            int rightMax = 0;
            for(int j = height.length - 1;j>i;j--){
                rightMax = Math.max(rightMax,height[j]);
            }
            // 当前可接雨水为
            int tempHeight = Math.min(leftMax,rightMax);
            if(tempHeight > height[i]){
                sum += tempHeight - height[i];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap2(height));
    }
}
