package vip.qmwk.leetcode.sort;

import java.util.Arrays;

public class ShellSort implements Sort {

    /**
     * 初始每组2个元素
     * @param
     */
//    @Override
//    public void sort(int[] arr) {
//        int num = arr.length;
//        for(int gap = num/2;gap > 0;gap/=2){
//            for(int i = gap;i<num;i++){
//                int j = i;
//                int temp = arr[i];
//                for(j = i - gap;j>=0 && temp < arr[j];j -= gap){
//                    arr[j + gap] = arr[j];
//                }
//                arr[j+gap] = temp;
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4,5,3,2,4,2,3,2,1};
        Sort sort = new ShellSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 初始每组3个元素
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int num = arr.length;
        for(int gap = num/3;gap > 0;gap/=3){
            for(int i = gap;i<num;i++){
                int temp = arr[i];
                int j = i - gap;
                while(j >= 0 && j < num && arr[j] > temp){
                    j -= gap;
                }
                for(int k = i;k>j + gap;k-=gap){
                    arr[k] = arr[k - gap];
                }
                arr[j + gap] = temp;
            }
        }
    }

}
