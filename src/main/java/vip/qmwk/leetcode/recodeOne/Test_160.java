package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/12/01/15:35
 * @Description:
 */
public class Test_160 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 4;
        ListNode node2 = new ListNode();
        node2.val = 1;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 8;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.val = 4;
        node3.next = node4;
        ListNode node5 = new ListNode();
        node5.val = 5;
        node4.next = node5;

        ListNode node11 = new ListNode();
        node11.val = 5;
        ListNode node22 = new ListNode();
        node22.val = 6;
        node11.next = node22;
        ListNode node33 = new ListNode();
        node33.val = 1;
        node22.next = node33;
        ListNode node44 = new ListNode();
        node44.val = 8;
        node33.next = node44;
        ListNode node55 = new ListNode();
        node55.val = 4;
        node44.next = node55;
        ListNode node66 = new ListNode();
        node66.val = 5;
        node55.next = node66;

        System.out.println(getIntersectionNode(node1, node11));
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode indexA = headA;
        ListNode indexB = headB;
        while(indexA != indexB){
            indexA = indexA.next;
            indexB = indexB.next;
            if(indexA == null && indexB == null){
                return null;
            }
            if(indexA == null){
                indexA = headB;
            }
            if(indexB == null){
                indexB = headA;
            }
        }
        return indexA;
    }
}
