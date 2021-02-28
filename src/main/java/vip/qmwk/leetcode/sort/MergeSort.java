package vip.qmwk.leetcode.sort;

import java.util.Arrays;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        slice(arr,0,arr.length - 1,temp);
    }

    private void slice(int[] arr, int begin, int end, int[] temp){
        if(begin >= end){
            return;
        }
        int mid = begin + (end - begin)/2;
        slice(arr, begin, mid, temp);
        slice(arr, mid + 1,end, temp);
        int leftIndex = begin;
        int rightIndex = mid + 1;
        int index = 0;
        while(leftIndex <= mid && rightIndex <= end){
            if(arr[leftIndex] < arr[rightIndex]){
                temp[index] = arr[leftIndex];
                index++;
                leftIndex++;
            }else{
                temp[index] = arr[rightIndex];
                index++;
                rightIndex++;
            }
        }
        while(leftIndex <= mid){
            temp[index] = arr[leftIndex];
            index++;
            leftIndex++;
        }
        while(rightIndex <= end){
            temp[index] = arr[rightIndex];
            index++;
            rightIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4,5,3,2,4,2,3,2,1};
        Sort sort = new MergeSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
