package vip.qmwk.leetcode.recodeOne;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/10/09/10:20
 * @Description:
 */
public class Test_15 {

    public static void main(String[] args) {
        int[] nums = {3,0,-2,-1,1,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <= 2){
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> sortTmp = new ArrayList<>();
        Map<Integer,Integer[]> map = new HashMap<>();
        for(int i = 0;i<nums.length-2;i++){
            int tmpi = nums[i];
            for (int j = i+1;j<nums.length;j++){
                int tmpj = nums[j];
                if(map.containsKey(tmpj)){
                    Integer[] integers = map.get(tmpj);
                    List<Integer> tmpList = Arrays.asList(integers);
                    tmp = new ArrayList<>(tmpList);
                    tmp.add(tmpj);
                    Collections.sort(tmp);
                    if(!sortTmp.contains(tmp)){
                        sortTmp.add(tmp);
                        result.add(tmp);
                    }
                }else{
                    map.put(0-tmpi-tmpj,new Integer[]{tmpi,tmpj});
                }
            }
            map.clear();
        }
        return result;
    }
}
