package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/20/11:22
 * @Description:
 */
public class Test_143 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        reorderList(l1);
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        // 获取中间节点
        ListNode midNode = midNode(head);
        ListNode first = head;
        ListNode second = midNode.next;
        midNode.next = null;
        // 反转链表
        ListNode reverseNode = reverseNode(second);
        // 合并链表
        mergeNode(first, reverseNode);
    }

    /**
     * 合并链表
     * @param first
     * @param second
     * @return
     */
    public static void mergeNode(ListNode first, ListNode second) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (first != null && second != null) {
            l1_tmp = first.next;
            l2_tmp = second.next;

            first.next = second;
            first = l1_tmp;

            second.next = first;
            second = l2_tmp;
        }
    }

    /**
     * 链表中点
     * @param head
     * @return
     */
    public static ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
