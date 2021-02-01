package vip.qmwk.leetcode.subject.doubleindex;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/29/10:19
 * @Description:
 */
public class Test_234 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(2);
//        l1.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 获取链表中点
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        // 反转mid之后的链表
        ListNode pre = null;
        while(mid != null){
            ListNode temp = mid.next;
            mid.next = pre;
            pre = mid;
            mid = temp;
        }
        // 判断是否为回文
        ListNode curr = dummy.next;
        ListNode reverse = pre;
        while(curr != null && reverse != null){
            if(curr.val != reverse.val){
                return false;
            }
            curr = curr.next;
            reverse = reverse.next;
        }
        if(curr == null && reverse == null){
            return true;
        }
        if(curr != null && curr.next == null){
            return true;
        }
        return false;
    }
}
