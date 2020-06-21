package vip.qmwk.leetcode;

/**
 * Unit test for simple App.
 */
public class Test_674
{


    public static void main(String[] args) {
        int[] input = {1,3,5,4,2,3,4,5};
        System.out.println(findLengthOfLCIS(input));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int length = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] < nums[i]){
                length++;
            }else{
                if(maxLength < length){
                    maxLength = length;
                }
                length = 1;
            }
            if((i == nums.length - 1) && maxLength < length){
                maxLength = length;
            }
        }
        return maxLength;
    }
}
