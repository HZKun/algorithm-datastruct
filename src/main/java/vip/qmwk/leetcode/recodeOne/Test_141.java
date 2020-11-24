package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/24/10:17
 * @Description:
 */
public class Test_141 {

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(slow.next == null){
                return false;
            }
            slow = slow.next;
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }
}
