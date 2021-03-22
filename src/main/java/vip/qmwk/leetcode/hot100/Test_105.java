package vip.qmwk.leetcode.hot100;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。注意:你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,8,10,20,15,7]
 * 中序遍历 inorder = [8,9,10,3,15,20,7]
 *      3
 *    /   \
 *   9     20
 * / \    /  \
 *8   10 15   7
 */
public class Test_105 {

    private static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 根据前序遍历获取根节点，根据中序遍历获取左右子树
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return tree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private static TreeNode tree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd){
        // 递归终止条件
        if(preBegin > preEnd || inBegin>inEnd){
            return null;
        }
        // 从preorder获取头结点
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);
        // 获取头结点在中序中索引
        int index = map.get(rootVal);
        // 在中序的index的左边为左子树，右边为右子树
        // 左子树长度
        int leftLen = index - inBegin;
        root.left = tree(preorder, preBegin + 1,preBegin + leftLen,inorder,inBegin,index-1);
        root.right = tree(preorder, preBegin + leftLen + 1,preEnd,inorder,index + 1,inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }


}
