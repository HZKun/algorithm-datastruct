package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/26/16:37
 * @Description:
 */
public class Test_92 {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        // 前进到反转处
        while(m > 1){
            curr = curr.next;
            pre = pre.next;
            m--;
            n--;
        }
        // 反转链表
        // 记录当前反转链表前一个节点(反转后为反转链表的前一个节点)，以及反转链表的第一个节点(反转后为反转链表的尾结点)
        ListNode con = pre;
        ListNode tail = curr;
        while(n > 0){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            n--;
        }
        // 连接反转的链表
        con.next = pre;
        tail.next = curr;
        return dummy.next;
    }

}
