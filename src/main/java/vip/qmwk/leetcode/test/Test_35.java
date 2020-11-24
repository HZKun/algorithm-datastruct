package vip.qmwk.leetcode.test;

public class Test_35
{


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int tmp = nums[0];
        if(target < tmp){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }else if(nums[i] < target){
                tmp = nums[i];
            }else{
                return i;
            }
        }
        return nums.length;
    }
}
