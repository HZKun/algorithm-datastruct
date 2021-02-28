package vip.qmwk.leetcode.sort;

import java.util.Arrays;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        quickSort(arr,0,length - 1);
    }

    private void quickSort(int[] arr, int begin, int end){
        if(begin < end){
            int index = getIndex(arr, begin, end);
            quickSort(arr,begin,index - 1);
            quickSort(arr,index + 1,end);
        }
    }

    private int getIndex(int[] arr, int begin, int end){
        // 以第一个数为基准
        int temp = arr[begin];
        while(begin < end){
            // 移动右节点,找到第一个比基准小的值
            while(arr[end] >= temp && end > begin){
                end--;
            }
            arr[begin] = arr[end];
            // 移动左节点，找到第一个比基准大的数
            while(arr[begin] <= temp && begin < end){
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = temp;
        return begin;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4,5,3,2,4,2,3,2,1};
        Sort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
