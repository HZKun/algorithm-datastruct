package vip.qmwk.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 *
 */
public class SelectSort implements Sort{

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4,5,3,2,4,2,3,2,1};
        Sort selectSort = new SelectSort();
        selectSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
