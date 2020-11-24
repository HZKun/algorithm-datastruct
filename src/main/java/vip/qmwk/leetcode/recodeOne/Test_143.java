package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/24/11:07
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
//        ListNode node5 = new ListNode();
//        node5.val = 5;
//        node4.next = node5;
        System.out.println(reorderList(node1));
    }

    public static ListNode reorderList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        int length = count;
        int mid = (count + 1)/2;
        count = 0;
        ListNode pre = new ListNode();
        head = dummy.next;
        while(head != null){
            count++;
            if(count> mid){
                ListNode tmp = new ListNode();
                tmp.val = head.val;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            head = head.next;
        }
        // 合并两链表dummy.next,pre.next
        ListNode l1 = dummy.next;
        ListNode l2 = pre.next;
        while(l1 != null && l2 != null){
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            l1 = next1;
            l2.next = l1;
            l2 = next2;
        }
        // 去除dummy中多余
        count = 0;
        ListNode tmp = dummy.next;
        while(tmp != null){
            count++;
            if(count >= length){
                tmp.next = null;
            }
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
