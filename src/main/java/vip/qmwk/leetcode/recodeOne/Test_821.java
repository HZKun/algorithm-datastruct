package vip.qmwk.leetcode.recodeOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/03/10:42
 * @Description:
 */
public class Test_821 {


    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s, c)));
    }


    public static int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == C) {
                index.add(i);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            int min = S.length() - 1;
            for (int j = 0; j < index.size(); j++) {
                int tmp = Math.abs(i - index.get(j));
                if (min > tmp) {
                    min = tmp;
                }
            }
            result[i] = min;
        }
        return result;
    }
}
