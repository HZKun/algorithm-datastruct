package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/25/10:55
 * @Description:
 */
public class Test_19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        int fastIndex = 1;
        while(fastIndex <= n){
            if(head != null){
                head = head.next;
            }else{
                return dummy.next;
            }
            fastIndex++;
        }
        ListNode pre = dummy;
        ListNode curr = dummy.next;
        while(head != null){
            head = head.next;
            pre = pre.next;
            curr = curr.next;
        }
        pre.next =  curr.next;
        return dummy.next;
    }
}
