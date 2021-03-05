package vip.qmwk.leetcode.hot100;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 输入：head = [1], n = 1
 * 输出：[]
 */
public class Test_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
            if(count == n){
                break;
            }
        }
        ListNode curr = dummy.next;
        ListNode prev = new ListNode();
        prev.next = curr;
        dummy.next = prev;
        while(head != null){
            head = head.next;
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next = new ListNode(6);
//        l1.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode = removeNthFromEnd(l1, 2);
        System.out.println(listNode);
    }
}
