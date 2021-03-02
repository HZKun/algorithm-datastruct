package vip.qmwk.leetcode.hot100;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Test_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode dummy = new ListNode();
        prev.next = dummy;
        boolean add = false;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val;
            if(add){
                sum += 1;
                add = false;
            }
            if(sum >= 10){
                add = true;
                sum -= 10;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val;
            if(add){
                sum += 1;
                add = false;
            }
            if(sum >= 10){
                add = true;
                sum -= 10;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val;
            if(add){
                sum += 1;
                add = false;
            }
            if(sum >= 10){
                add = true;
                sum -= 10;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l2 = l2.next;
        }
        if(add){
            ListNode curr = new ListNode(1);
            dummy.next = curr;
        }
        return prev.next.next;
    }

    /**
     * 反转链表
     * @param head
     */
    private static ListNode reverseListNode(ListNode head){
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
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(l1,l2));
    }
}
