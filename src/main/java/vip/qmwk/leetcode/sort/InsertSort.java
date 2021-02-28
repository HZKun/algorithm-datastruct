package vip.qmwk.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 将每一张牌插入到其他已经有序的牌中的适当位置。当我们给无序数组做排序的时候，为了要插入元素，我们需要腾出空间，将其余所有元素在插入之前都向右移动一位，这种算法我们称之为插入排序。
 */
public class InsertSort implements Sort{


    @Override
    public void sort(int[] arr) {
        for(int i = 1;i<arr.length;i++){
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp){
                j--;
            }
            for(int k = i;k>j + 1;k--){
                arr[k] = arr[k - 1];
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,4,5,3,2,4,2,3,2,1};
        Sort sort = new InsertSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
