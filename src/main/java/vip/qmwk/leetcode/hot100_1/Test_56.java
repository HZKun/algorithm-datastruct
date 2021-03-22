package vip.qmwk.leetcode.hot100_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
 */
public class Test_56 {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        // 先对intervals排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1 == null){
                    return 1;
                }
                if(o2 == null){
                    return -1;
                }
                return o1[0]-o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] init = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(canMerge(init,intervals[i])){
                init[0] = Math.min(init[0], intervals[i][0]);
                init[1] = Math.max(init[1], intervals[i][1]);
            }else{
                result.add(init);
                init = intervals[i];

            }
        }
        result.add(init);
        return result.toArray(new int[result.size()][]);
    }

    private static boolean canMerge(int[] o1, int[] o2){
        if(o1 == null || o2 == null){
            return false;
        }
        return (o2[0] >= o1[0] && o2[0] <= o1[o1.length - 1]) || (o1[0] >= o2[0] && o1[0] <= o2[o2.length - 1]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5},{5,10}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.toString(merge));
    }
}
