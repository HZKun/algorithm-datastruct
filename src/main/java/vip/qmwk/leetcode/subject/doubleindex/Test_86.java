package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/25/11:42
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
        System.out.println(partition(l1,3));
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        ListNode bigDummy = new ListNode();
        ListNode bigNode = bigDummy;
        while(head != null){
            if(head.val <x){
                curr.next = head;
                curr = curr.next;
            }else{
                bigNode.next = head;
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        bigNode.next = null;
        curr.next = bigDummy.next;
        return dummy.next;
    }
}
