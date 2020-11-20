package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/19/16:02
 * @Description:
 */
public class Test_86 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 4;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 3;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.val = 2;
        node3.next = node4;
        ListNode node5 = new ListNode();
        node5.val = 5;
        node4.next = node5;
        ListNode node6 = new ListNode();
        node6.val = 2;
        node5.next = node6;
        System.out.println(partition(node1,3));
    }



    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tag = head;
        ListNode preTag = dummy;
        ListNode pre = dummy;
        boolean needChange = false;
        while (head != null){
            int val = head.val;
            if(val < x){
                if(needChange){
                    changeNode(pre, head, preTag, tag);
                    preTag = head;
                    head = pre;
                }
            }else{
                if(!needChange){
                    tag = head;
                    preTag = pre;
                    needChange = true;
                }
            }
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

    private static void changeNode(ListNode pre, ListNode head, ListNode preTag, ListNode tag){
        pre.next = head.next;
        head.next = tag;
        preTag.next = head;
    }
}
