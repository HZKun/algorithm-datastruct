package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/12/10:31
 * @Description:
 */
public class Test_61 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node1.next = node2;
//        ListNode node3 = new ListNode();
//        node3.val = 3;
//        node2.next = node3;
//        ListNode node4 = new ListNode();
//        node4.val = 4;
//        node3.next = node4;
//        ListNode node5 = new ListNode();
//        node5.val = 5;
//        node4.next = node5;
        System.out.println(rotateRight(node1, 5));
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        System.out.println(head);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 此时head为尾结点
        int size = 1;
        while (head.next != null) {
            head = head.next;
            size++;
        }
        k = k >= size ? (k%size) : k;
        if(k == 0){
            return dummyHead.next;
        }
        k = size - k;
        ListNode tmp = new ListNode(0);
        tmp.next = dummyHead.next;
        for (int i = 0; i < k; i++){
            tmp = tmp.next;
        }
        ListNode result = tmp.next;
        tmp.next = null;
        head.next = dummyHead.next;
        return result;

    }
}
