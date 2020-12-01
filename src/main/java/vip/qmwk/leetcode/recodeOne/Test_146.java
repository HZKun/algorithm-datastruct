package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/12/01/16:23
 * @Description:
 */
public class Test_146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.put(3, 3);
        lRUCache.get(2);
        lRUCache.put(4, 4);
        lRUCache.get(1);
        lRUCache.get(2);
        lRUCache.get(4);
    }


}


class LRUCache {
    private int capacity;  // 容量
    private int size;
    private Map<Integer, ListNode> map;
    private ListNode head;  // 链表头数据
    private ListNode tail;  // 尾数据

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        // 将当前元素排到队头
        ListNode listNode = map.get(key);
        if(listNode == null){
            return -1;
        }
        if(size == 1){
            return listNode.val;
        }
        ListNode pre = listNode.pre;
        ListNode next = listNode.next;
        pre.next = next;
        if(next == null){
            // listNode为尾元素
            tail = pre;
        }
        add(listNode.val);
        return listNode.val;
    }

    public void put(int key, int value){
        if(size >= capacity){
            // 删除尾元素，新增新元素
            int tailKey = 0;
            for (Map.Entry<Integer, ListNode> entries: map.entrySet()) {
                ListNode tmp = entries.getValue();
                if(tmp.val == tail.val){
                    tailKey = entries.getKey();
                }
            }
            map.remove(tailKey);
            ListNode pre = tail.pre;
            if(pre != null){
                pre.next = null;
                tail = pre;
            }
            size--;
        }
        // 头部添加
        ListNode tmp = add(value);
        map.put(key, tmp);
        size++;
    }

    /**
     * 链表头加元素
     * @param value
     */
    private ListNode add(int value){
        ListNode tmp = new ListNode(value);
        if(size == 0){
            head = tmp;
            tail = tmp;
        }else{
            if(size == 1){
                // 处理尾结点的前置元素
                tail.pre = tmp;
            }
            ListNode curr = head;
            head = tmp;
            head.next = curr;
            curr.pre = head;
        }
        return tmp;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Integer, ListNode> getMap() {
        return map;
    }

    public void setMap(Map<Integer, ListNode> map) {
        this.map = map;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
