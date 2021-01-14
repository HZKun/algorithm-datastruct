package vip.qmwk.leetcode.recodeTwo.array;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/13/11:32
 * @Description:
 */
public class Test_859 {

    public static void main(String[] args) {
        String A = "", B = "aaaaaaacb";
        System.out.println(buddyStrings(A,B));
    }


    public static boolean buddyStrings(String A, String B) {
        if(A == null || A.length() < 2 || B == null || B.length() < 2 || A.length() != B.length()){
            return false;
        }
        boolean twoEuqal = false;
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<A.length();i++){
            if(A.charAt(i) != B.charAt(i)) {
                list.add(i);
            }
            if(!map.containsKey(A.charAt(i))){
                map.put(A.charAt(i),1);
            }else{
                twoEuqal = true;
            }
        }
        if(A.equals(B) && twoEuqal){
            return true;
        }
        if(list.size() != 2){
            return false;
        }
        char[] chars = A.toCharArray();
        char tmp = chars[list.get(0)];
        chars[list.get(0)] = chars[list.get(1)];
        chars[list.get(1)] = tmp;
        return String.valueOf(chars).equals(B);
    }
}
