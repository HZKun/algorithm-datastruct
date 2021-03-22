package vip.qmwk.leetcode.hot100;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的
 *
 *      1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 */
public class Test_101 {


    public static boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private static boolean check(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        return check(node1.left,node2.right) & check(node1.right,node2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }


}
