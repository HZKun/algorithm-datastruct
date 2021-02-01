package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;
/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/29/10:20
 * @Description:
 */
public class Test_876 {

    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next == null){
            return slow;
        }else{
            return slow.next;
        }
    }
}
