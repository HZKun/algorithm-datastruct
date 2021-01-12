package vip.qmwk.leetcode.recodeTwo.array;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/12/14:37
 * @Description:
 */
public class Test_380 {


}

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer,Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer num = map.get(val);
        if(num != null){
            return false;
        }
        int size = list.size();
        list.add(size,val);
        map.put(val,size);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = map.remove(val);
        if (index == null) return false;
        if (index != list.size() - 1) {
            int last = list.remove(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
        } else {
            list.remove(list.size() - 1);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
