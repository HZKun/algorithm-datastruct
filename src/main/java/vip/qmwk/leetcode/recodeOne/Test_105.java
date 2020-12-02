package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.leetcode.recodeOne.bean.TreeNode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 前序遍历与中序遍历构造树
 *
 * @Auther: HZK
 * @Date: 2020/12/02/11:33
 * @Description:
 */
public class Test_105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序遍历---根左右
        // 中序遍历---左根右

    }

    /**
     * 构造根节点为root的树的左右子树
     *
     * @param preorder
     * @param inorder
     * @param root
     * @return
     */
    private static TreeNode buildTreeNode(int[] preorder, int pStart, int[] inorder, int iStart, int iEnd, TreeNode root) {

    }

    private static int getIndex(int value, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
