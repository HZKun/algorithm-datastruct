package vip.qmwk.leetcode.hot100;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 */
public class Test_98 {

    /**
     * 栈---中序遍历
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long inOrder = Long.MAX_VALUE;
        while(!stack.isEmpty() || root != null){
            // 左子树一路入栈到底,栈里面为左子树所有节点，出一个就是左节点，然后栈顶就是刚出的左节点的根节点。
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            // 出栈顶，即左子树最左面的节点
            root = stack.pop();
            if(root.val < inOrder){
                return false;
            }
            inOrder = root.val;
            // 获取当前节点的右节点
            root = root.right;
        }
        return true;
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    private static boolean isBST(TreeNode root, long low, long max){
        if(root == null){
            return true;
        }
        if(root.val <= low || root.val >= max){
            return false;
        }
        return isBST(root.left,low,root.val) & isBST(root.right, root.val, max);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(isValidBST(root));
    }
}
