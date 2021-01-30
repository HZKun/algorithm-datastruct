package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

public class Test_92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // 去除m之前的数据
        while(m > 1){
            prev = prev.next;
            curr = curr.next;
            m--;
            n--;
        }
        // 反转链表
        ListNode con = prev;
        ListNode tail = curr;
        while(n > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            n--;
        }
        con.next = prev;
        tail.next = curr;
        return dummy.next;
    }
}
