package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/14/10:26
 * @Description:
 */
public class Test_82 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(4);
        System.out.println(deleteDuplicates(l1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                pre.next = head.next;
            }else{
                pre = pre.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
