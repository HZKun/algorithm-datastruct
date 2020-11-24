package vip.qmwk.leetcode.test;

import java.util.HashMap;
import java.util.Map;

public class Test_1160
{


    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        char[] chs = chars.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i<chs.length; i++){
            if(map.containsKey(chs[i])){
                map.put(chs[i],map.get(chs[i]) + 1);
            }else{
                map.put(chs[i],1);
            }
        }
        for (String word:words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            boolean needAdd = true;
            for(int i = 0;i<word.length(); i++){
                Character ch = word.charAt(i);
                if(!map.containsKey(ch)){
                    needAdd = false;
                }
                if(wordMap.containsKey(ch)){
                    wordMap.put(ch,wordMap.get(ch) + 1);
                }else{
                    wordMap.put(ch,1);
                }
            }
            boolean add = true;
            for(Map.Entry<Character, Integer> entry :wordMap.entrySet()){
                if(!needAdd || entry.getValue() > map.get(entry.getKey())){
                    add = false;
                    break;
                }
            }
            if(add){
                result += word.length();
            }
        }
        return result;
    }
}
