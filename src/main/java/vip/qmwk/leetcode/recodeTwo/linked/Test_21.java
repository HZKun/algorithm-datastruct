package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/13/15:38
 * @Description:
 */
public class Test_21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1,l2));
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
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                result.next = l1;
                l1 = l1.next;
            }else{
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        while(l1 != null){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }
        while(l2 != null){
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }
        return dummy.next.next;
    }
}
