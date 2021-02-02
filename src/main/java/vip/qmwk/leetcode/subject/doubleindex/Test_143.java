package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/29/10:19
 * @Description:
 */
public class Test_143 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 3;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.val = 4;
        node3.next = node4;
        ListNode node5 = new ListNode();
        node5.val = 5;
        node4.next = node5;
        reorderList(node1);
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 获取链表中点
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode curr = dummy.next;
        ListNode reverse = mid.next;
        mid.next = null;
        // 把mid后面链表反转
        ListNode pre = null;
        while(reverse != null){
            ListNode temp = reverse.next;
            reverse.next = pre;
            pre = reverse;
            reverse = temp;
        }
        // 把前后两链表合并
        reverse = pre;
        while(curr != null && reverse != null){
            ListNode temp1 = curr.next;
            ListNode temp2 = reverse.next;
            curr.next = reverse;
            curr = temp1;
            reverse.next = curr;
            reverse = temp2;
        }
        System.out.println(head);
    }
}
