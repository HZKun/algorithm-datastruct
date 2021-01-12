package vip.qmwk.leetcode.recodeTwo.array;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * @Auther: HZK
 * @Date: 2021/01/12/10:45
 * @Description:
 */
public class Test_75 {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortColors(nums)));
    }


    public static int[] sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        // p0为区间0带交换的坐标，p1为区间1待交换的坐标
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // 交换p0和i位置，然后交换p1和i位置
                swap(nums, p0, i);
                if(p0<p1){
                    swap(nums, p1, i);
                }
                p0++;
                p1++;

            } else if (nums[i] == 1) {
                // 交换p1和i位置
                swap(nums, p1, i);
                p1++;
            }
        }
        return nums;
    }

    /**
     * 交换index1和index2的位置
     *
     * @param nums
     * @param index1
     * @param index2
     */
    public static boolean swap(int[] nums, int index1, int index2) {
        if (index1 == index2 || index1 >= nums.length || index2 >= nums.length || nums[index1] == nums[index2]) {
            return false;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        return true;
    }
}
