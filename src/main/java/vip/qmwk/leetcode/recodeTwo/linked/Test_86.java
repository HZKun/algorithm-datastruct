package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/14/14:49
 * @Description:
 */
public class Test_86 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);
        System.out.println(partition(l1,1));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lessNode = new ListNode();
        ListNode bigNode = new ListNode();
        ListNode dummy1 = lessNode;
        ListNode dummy2 = bigNode;
        while(head != null){
            if(head.val < x){
                lessNode.next = head;
                lessNode = lessNode.next;
            }else{
                bigNode.next = head;
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        bigNode.next = null;
        lessNode.next = dummy2.next;
        return dummy1.next;
    }
}
