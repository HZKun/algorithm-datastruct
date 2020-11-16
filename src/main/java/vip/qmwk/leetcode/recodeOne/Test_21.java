package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/16/14:53
 * @Description:
 */
public class Test_21 {

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
        node4.val = 1;
        ListNode node5 = new ListNode();
        node5.val = 2;
        node4.next = node5;
        ListNode node6 = new ListNode();
        node6.val = 4;
        node5.next = node6;
        System.out.println(node1.toString());
        System.out.println(node4.toString());
        System.out.println(mergeTwoLists(node1,node4).toString());
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode result = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = result;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                result.val = l1.val;
                l1 = l1.next;
            }else {
                result.val = l2.val;
                l2 = l2.next;
            }
            result.next = new ListNode();
            result = result.next;
        }
        while (l1 != null){
            result.val = l1.val;
            l1 = l1.next;
            if(l1 != null){
                result.next = new ListNode();
                result = result.next;
            }
        }
        while (l2 != null){
            result.val = l2.val;
            l2 = l2.next;
            if(l2 != null){
                result.next = new ListNode();
                result = result.next;
            }
        }
        return dummy.next;
    }
}
