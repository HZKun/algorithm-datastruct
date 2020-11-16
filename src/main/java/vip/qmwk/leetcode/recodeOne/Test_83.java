package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/16/16:10
 * @Description:
 */
public class Test_83 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 1;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 3;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.val = 3;
        node3.next = node4;
        System.out.println(deleteDuplicates(node1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (true){
            if(head.next == null){
                return dummy.next;
            }
            if(head.val == head.next.val){
                pre.next = head.next;
                head = head.next;
            }else{
                pre = head;
                head = head.next;
            }
        }
    }
}
