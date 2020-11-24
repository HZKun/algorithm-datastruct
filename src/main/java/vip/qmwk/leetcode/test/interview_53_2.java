package vip.qmwk.leetcode.test;

public class interview_53_2
{


    public static void main(String[] args) {
        int[] input = {0,1};
        System.out.println(search(input,2));


    }

    public static int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return 1;
            }else if(nums[0] == 1){
                return 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i]){
                return i;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
