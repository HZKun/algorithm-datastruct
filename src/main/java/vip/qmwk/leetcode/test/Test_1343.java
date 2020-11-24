package vip.qmwk.leetcode.test;

public class Test_1343
{


    public static void main(String[] args) {
        int[]arr = new int[]{11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int threshold = 5;
        System.out.println(numOfSubarrays(arr,k,threshold));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr.length < k) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum / k >= threshold) {
                count++;
            }
        }
        return count;
    }
}
