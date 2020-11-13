package vip.qmwk.leetcode.recodeOne;

import vip.qmwk.datastruct.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/13/11:24
 * @Description:
 */
public class Test_104 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode right = new TreeNode();
        right.val = 2;
        root.right = right;
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getTreeNode(root, 0);
    }

    /**
     * 获取当前treeNode的左右子树
     * @param treeNode
     * @param size
     * @return
     */
    private static int getTreeNode(TreeNode treeNode, int size){
        if(treeNode == null){
            return size;
        }
        size++;
        TreeNode left = treeNode.left;
        int leftSize = 0;
        int rightSize = 0;
        if(left != null){
            leftSize = getTreeNode(left, size);
        }else{
            leftSize = size;
        }
        TreeNode right = treeNode.right;
        if(right != null){
            rightSize = getTreeNode(right, size);
        }else{
            rightSize = size;
        }
        return Math.max(leftSize, rightSize);
    }
}
