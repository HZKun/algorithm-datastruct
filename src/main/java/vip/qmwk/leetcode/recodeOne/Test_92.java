package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/19/21:31
 * @Description:
 */
public class Test_92 {

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
        ListNode node5 = new ListNode();
        node5.val = 5;
        node4.next = node5;
        System.out.println(reverseBetween(node1,1,2));
    }



    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m==n){
            return head;
        }
        ListNode result = new ListNode();
        ListNode revese = null;
        ListNode dummy = new ListNode();
        dummy.next = result;
        ListNode dummyRevese = new ListNode();
        dummyRevese.next = revese;
        int num = 0;
        while(head != null){
            num++;
            ListNode tmp = new ListNode();
            tmp.val = head.val;
            if(num < m){
                result.next = tmp;
                head = head.next;
                result = result.next;
            }else if(num<=n){
                // 新链表添加元素
                if(revese == null){
                    revese = tmp;
                    dummyRevese.next = revese;
                }else{
                    ListNode next = dummyRevese.next;
                    dummyRevese.next = tmp;
                    tmp.next = next;
                }
                head = head.next;
            }else{
                // 将剩余的元素加到revese尾部
                revese.next = tmp;
                revese = revese.next;
                head = head.next;
            }
        }
        result.next = dummyRevese.next;
        return dummy.next.next;
    }
}
