package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.datastruct.tree.TreeNode;
import vip.qmwk.leetcode.recodeOne.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/12/11:38
 * @Description:
 */
public class Test_109 {

    private static ListNode node;

    public static TreeNode sortedListToBST(ListNode head) {
        node = head;
        ListNode tmp = head;
        int length = 0;
        // 获取当前链表长度
        while (tmp != null){
            length++;
            tmp = tmp.next;
        }
        return buildTree(0,length - 1);

    }

    /**
     * 以链表left到right的数据建立树
     * @param left
     * @param right
     * @return
     */
    private static TreeNode buildTree(int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right + 1)/2;
        // 建立当前节点
        TreeNode treeNode = new TreeNode();
        // 建立当前树左节点
        TreeNode leftTree = buildTree(left, mid - 1);
        treeNode.left = leftTree;
        // 建立当前树中间节点
        treeNode.val = node.val;
        // node值被使用，切换下一个值
        node = node.next;
        // 建立当前树右节点
        TreeNode rightTree = buildTree(mid + 1, right);
        treeNode.right = rightTree;
        return treeNode;
    }





    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val = -10;
        ListNode node2 = new ListNode();
        node2.val = -3;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.val = 0;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.val = 5;
        node3.next = node4;
        ListNode node5 = new ListNode();
        node5.val = 9;
        node4.next = node5;
        sortedListToBST(node1);
    }

}
