package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

public class Test_offer_24 {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        System.out.println(reverseList(l1));
    }
}
