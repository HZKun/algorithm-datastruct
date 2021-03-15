package vip.qmwk.leetcode.hot100;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class Test_42 {

    /**
     * 栈方法---说到栈，我们肯定会想到括号匹配了。
     * 可以和括号匹配类比下。每次匹配出一对括号（找到对应的一堵墙），就计算这两堵墙中的水。
     * @param height
     * @return
     */
    public static int trap5(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        int result = 0;
        // 栈中存储索引,便于计算水的面积
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<height.length;i++){
            // 栈不为空且当前元素大于栈顶元素
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                // 则一直出栈，因为栈底必为左边最大值(比栈底小的之前的元素已出栈，之后的元素都是小于栈顶的才入栈，则栈中元素必递减或相等)算可累计水
                Integer pop = stack.pop();
                // 如果出了一个栈为空，说明左边没有可以形成墙的柱子，水为0,
                if(stack.isEmpty()){
                    break;
                }
                // 两墙之前的距离,为i与当前出了一个栈后栈顶元素的差
                int din = i - stack.peek() - 1;
                // 高度为当前元素与栈顶元素的较小值减当前出栈的高度
                int h = Math.min(height[i], height[stack.peek()]) - height[pop];
                result += din * h;
            }
            stack.push(i);

        }
        return result;
    }


    /**
     * 双指针优化---从动态规划优化来
     * trap3中获取左边最大值需要从左向右遍历，获取右边最大值需要从右向左遍历一共两次遍历
     * 参考Test_11称最多水的容器，能不能一次循环获取每个柱子的值
     * 核心在于：
     *          当从左往右循环到left坐标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的(即trap3从左向右循环里面的注释)。
     *          同理从右向左循环到right坐标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
     *          那么当我们当前在left时，它左边最大值一定是left_max，右边最大值>=当前记录的right_max(因为left<right，因此最小也是right右边最大值)，
     *          这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。
     *          无论右边将来会不会出现更大的right_max，都不影响这个结果。
     *          所以当left_max<right_max时，left坐标的水就已知，我们就希望去处理left+1下标，反之，我们希望去处理right下标
     *
     * @param height
     * @return
     */
    public static int trap4(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        int result = 0;
        int left = 1;
        int right = height.length - 2;
        int leftMax = height[left - 1];
        int rightMax = height[right + 1];
        while(left <= right){
            if(leftMax < rightMax){
                // 当前left坐标的水便可记录
                if(leftMax > height[left]){
                    result += leftMax - height[left];
                }
                // 更新leftMax
                leftMax = Math.max(leftMax,height[left]);
                // 然后处理left+1坐标的水
                left++;
            }else{
                // 当前right坐标的水便可记录
                if(rightMax > height[right]){
                    result += rightMax - height[right];
                }
                rightMax = Math.max(rightMax,height[right]);
                right--;
            }
        }
        return result;
    }


    /**
     * 动态规划---从trap2优化得来
     * 获取每个柱子左右的最大值可优化为获取上一个已判断完的左右最大值与当前值的左右柱子比较
     * 即i移动一位，左边最大值为上一个最大值与当前i-1的值的最大值。右边最大值同理
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        int result = 0;
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        // 左边最大值初始化
        for(int i = 1;i<height.length - 1;i++){
            int leftMax = Math.max(leftMaxArr[i - 1], height[i - 1]);
            leftMaxArr[i] = leftMax;
            // 右边最大值不能在这里面循环，因为rightMaxArr初始化值都为0,导致计算出错。得从右到左循环计算右边最大值
            // int rightMax = Math.max(rightMaxArr[i + 1], height[i + 1]);
            // rightMaxArr[i] = rightMax;
        }
        // 右边最大值初始化
        for(int i = height.length - 2;i>=1;i--){
            int rightMax = Math.max(rightMaxArr[i + 1], height[i + 1]);
            rightMaxArr[i] = rightMax;
        }
        // 开始循环计算每个柱子的值
        for(int i = 1;i<height.length - 1;i++){
            int tempHeight = Math.min(leftMaxArr[i],rightMaxArr[i]);
            if(tempHeight > height[i]){
                result += tempHeight - height[i];
            }
        }
        return result;
    }



    /**
     * 以每个柱可存储水循环获取累加水
     * 获取每个柱子左右的最大值判断当前柱子可存储水数量
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
         if(height.length <= 2){
             return 0;
         }
         int result = 0;
         for(int i = 1;i<height.length - 1;i++){
             // i为当前柱子，获取当前柱子左右的最大值。柱子坐标为0,length-1的可存储水为0，故可以不考虑
             int leftIndex = i - 1;
             int leftMax = height[leftIndex];
             while(leftIndex >= 0){
                 leftMax = Math.max(leftMax,height[leftIndex]);
                 leftIndex--;
             }
             int rightIndex = i + 1;
             int rightMax = height[rightIndex];
             while(rightIndex < height.length){
                 rightMax = Math.max(rightMax,height[rightIndex]);
                 rightIndex++;
             }
             // 则当前柱子可存储水为左右最高柱子的较小值减当前柱子高度
             int tempHeight = Math.min(leftMax,rightMax);
             if(tempHeight > height[i]){
                 result += tempHeight - height[i];
             }
         }
         return result;
    }


    /**
     * 直观方法，以水的高度为循环条件累加水--超出时间限制
     * 水的高度从1~最大值，可计算的水满足左右都有高于水的高度的柱子
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        int result = 0;
        int maxVaule = getMaxVaule(height);
        // i定义为高度为i的水
        for(int i = 1;i<=maxVaule;i++){
            int tempWater = 0;
            boolean addWater = false;
            for(int j = 0;j<height.length;j++){
                if(height[j] >= i){
                    // 当前高度高于所求水i的高度，第一次改准备状态，第二次才加result，
                    // 并更新准备状态及左高度
                   result += tempWater;
                   tempWater = 0;
                   addWater = true;
                }else{
                    if(addWater){
                        tempWater += 1;
                    }
                }
            }
        }
        return result;
    }

    private static int getMaxVaule(int[] height){
        int max = height[0];
        for(int i = 1;i<height.length;i++){
            max = Math.max(max,height[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        int trap = trap5(arr);
        System.out.println(trap);
    }


}
