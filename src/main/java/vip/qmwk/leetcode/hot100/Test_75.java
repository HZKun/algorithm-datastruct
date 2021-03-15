package vip.qmwk.leetcode.hot100;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class Test_75 {

    public static void sortColors(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        for(int i = leftIndex;i<=rightIndex;i++){
            while(i<=rightIndex && nums[i] == 2){
                int swap = nums[rightIndex];
                nums[rightIndex] = nums[i];
                nums[i] = swap;
                rightIndex--;
            }
            if(nums[i] == 0){
                int swap = nums[leftIndex];
                nums[leftIndex] = nums[i];
                nums[i] = swap;
                leftIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,2,2,0,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
