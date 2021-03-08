package vip.qmwk.leetcode.hot100;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

import java.util.List;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Test_23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        ListNode result = new ListNode();
        ListNode dummy = new ListNode();
        result.next = dummy;
        if(length == 0){
            return null;
        }
        if(length == 1){
            return lists[0];
        }
        while(true){
            boolean hasValue = false;
            int min = Integer.MAX_VALUE;
            int nextIndex = 0;
            for(int i = 0;i<length;i++){
                ListNode node = lists[i];
                if(node != null){
                    hasValue = true;
                    if(min > node.val){
                        min = node.val;
                        nextIndex = i;
                    }
                }
            }
            if(hasValue){
                ListNode temp = lists[nextIndex];
                dummy.next = new ListNode(temp.val);
                dummy = dummy.next;
                temp = temp.next;
                lists[nextIndex] = temp;
            }else{
                return result.next.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] arr = new ListNode[]{};
        ListNode listNode = mergeKLists(arr);
        System.out.println(listNode);
    }
}
