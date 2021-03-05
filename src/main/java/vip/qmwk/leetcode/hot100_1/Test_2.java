package vip.qmwk.leetcode.hot100_1;

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
        // 进位标志
        boolean add = false;
        int sum = 0;
        ListNode dummy = new ListNode();
        ListNode result = new ListNode();
        dummy.next = result;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val;
            sum = add?sum + 1:sum;
            if(sum >= 10){
                add = true;
            }else{
                add = false;
            }
            sum %= 10;
            result.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        while(l1 != null){
            sum = l1.val;
            sum = add?sum + 1:sum;
            if(sum >= 10){
                add = true;
            }else{
                add = false;
            }
            sum %= 10;
            result.next = new ListNode(sum);
            l1 = l1.next;
            result = result.next;
        }
        while(l2 != null){
            sum = l2.val;
            sum = add?sum + 1:sum;
            if(sum >= 10){
                add = true;
            }else{
                add = false;
            }
            sum %= 10;
            result.next = new ListNode(sum);
            l2 = l2.next;
            result = result.next;
        }
        if(add){
            result.next = new ListNode(1);
        }
        return dummy.next.next;
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
