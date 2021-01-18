package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/15/10:23
 * @Description:
 */
public class Test_92 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        System.out.println(reverseBetween(l1,1,2));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // 前进到需要反转链表处
        while(m > 1){
            curr = curr.next;
            prev = prev.next;
            m--;
            n--;
        }
        // 此时m=1
        ListNode con = prev;
        ListNode tail = curr;
        // 开始反转链表
        while(n > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            n--;
        }
        // 反转部分完成后
        con.next = prev;
        tail.next = curr;
        return dummy.next;
    }






    private static ListNode nextNode = null;

    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        // base case
        if(m == 1){
            return reverseListNode(head,n);
        }
        // 前进到base case触发递归
        head.next = reverseBetween1(head.next,m-1,n-1);
        return head;
    }

    /**
     * 反转head为头节点的前n个节点，返回反转后的头节点
     * @param head
     * @param n
     * @return
     */
    private static ListNode reverseListNode(ListNode head, int n){
        // 反转节点后的一个节点,即第n+1个节点
        if(n == 1){
            nextNode = head.next;
            return head;
        }
        ListNode lastNode = reverseListNode(head.next, n - 1);
        head.next.next = head;
        head.next = nextNode;
        return lastNode;
    }




    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null || m == n){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        head = dummy.next;
        int[] arr = new int[length];
        int index = 0;
        while(head != null){
            if(index + 1 < m || index + 1 > n){
                arr[index] = head.val;
            }else{
                arr[m+n-1-index-1] = head.val;
            }
            index++;
            head = head.next;
        }
        head = dummy.next;
        for(int i = 0;i<arr.length;i++){
            head.val = arr[i];
            head = head.next;
        }
        return dummy.next;
    }
}
