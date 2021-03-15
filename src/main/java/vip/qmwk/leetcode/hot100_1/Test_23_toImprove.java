package vip.qmwk.leetcode.hot100_1;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

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
public class Test_23_toImprove {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1){
            return lists[0];
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(true){
            int minValue = Integer.MAX_VALUE;
            int index = 0;
            boolean hasValue = false;
            for(int i = 0;i<lists.length;i++){
                ListNode temp = lists[i];
                if(temp == null){
                    continue;
                }
                hasValue = true;
                if(temp.val < minValue){
                    minValue = temp.val;
                    index = i;
                }
            }
            if(!hasValue){
                break;
            }
            ListNode currListNode = lists[index];
            curr.next = currListNode;
            curr = curr.next;
            lists[index] = currListNode.next;
        }
        return dummy.next;
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

        ListNode[] arr = new ListNode[]{l1,l2,l3};
        ListNode listNode = mergeKLists(arr);
        System.out.println(listNode);
    }
}
