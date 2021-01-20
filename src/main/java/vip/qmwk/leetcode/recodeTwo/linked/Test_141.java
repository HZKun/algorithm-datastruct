package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/20/10:16
 * @Description:
 */
public class Test_141 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
            if(first == second){
                return true;
            }
        }
        return false;
    }
}
