package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;
import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

public class Test_109 {

    public static TreeNode sortedListToBST(ListNode head) {
        // 将链表放入数组中
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 获取链表长度
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        int[] arr = new int[length];
        int i = 0;
        while(dummy.next != null){
            arr[i] = dummy.next.val;
            dummy = dummy.next;
            i++;
        }
        return buildTree(0, arr.length - 1, arr);
    }

    private static TreeNode buildTree(int begin, int end, int[] arr){
        if(begin > end){
            return null;
        }
        if(begin == end){
            return new TreeNode(arr[begin]);
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildTree(begin, mid - 1, arr);
        root.right = buildTree(mid + 1, end, arr);
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        l1.next = new ListNode(-3);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(9);
        System.out.println(sortedListToBST(l1));
    }
}
