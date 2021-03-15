package vip.qmwk.leetcode.hot100_1;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Test_23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        return merge(0,lists.length - 1,lists);
    }

    private static ListNode merge(int left, int right, ListNode[] lists){
        if(left > right){
            return null;
        }
        if(left == right){
            return lists[right];
        }
        int mid = left + (right - left)/2;
        ListNode l1 = merge(left, mid, lists);
        ListNode l2 = merge(mid + 1, right, lists);
        return merge2List(l1,l2);
    }

    private static ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] arr = new ListNode[]{l1, l2, l3};
        ListNode listNode = mergeKLists(arr);
        System.out.println(listNode);
    }
}
