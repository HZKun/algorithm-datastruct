package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/29/10:18
 * @Description:
 */
public class Test_142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = dummy.next;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;

    }
}
