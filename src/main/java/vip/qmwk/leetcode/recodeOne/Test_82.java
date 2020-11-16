package vip.qmwk.leetcode.recodeOne;


import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/16/16:23
 * @Description:
 */
public class Test_82 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 1;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 1;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.val = 2;
        node3.next = node4;
        ListNode node5 = new ListNode();
        node5.val = 3;
        node4.next = node5;
        ListNode node6 = new ListNode();
        node6.val = 3;
        node5.next = node6;
        ListNode node7 = new ListNode();
        node7.val = 4;
        node6.next = node7;
        System.out.println(deleteDuplicates(node1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null){
            boolean movePre = true;
            ListNode next = curr.next;
            while(curr.val == next.val){
                next = next.next;
                movePre = false;
                if(next == null){
                    break;
                }
            }
            if(movePre){
                pre = curr;
            }else{
                pre.next = next;
            }
            curr = next;
        }


        return dummy.next;
    }
}
