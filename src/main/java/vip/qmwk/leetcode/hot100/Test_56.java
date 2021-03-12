package vip.qmwk.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
 *
 */
public class Test_56 {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        int[] temp = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(canMerge(intervals[i],temp)){
                temp = merge(intervals[i], temp);
            }else{
                merged.add(temp);
                temp = intervals[i];
            }
        }
        merged.add(temp);
        return merged.toArray(new int[merged.size()][]);
    }

    private static int[] merge(int[] arr1,int[] arr2){
        return new int[]{Math.min(arr1[0],arr2[0]),Math.max(arr1[1],arr2[1])};
    }

    private static boolean canMerge(int[] arr1,int[] arr2){
        return (arr1[0] <= arr2[0] && arr1[1] >= arr2[0]) || (arr2[0] <= arr1[0] && arr2[1] >= arr1[0]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5},{6,7},{}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.toString(merge));
    }

}
