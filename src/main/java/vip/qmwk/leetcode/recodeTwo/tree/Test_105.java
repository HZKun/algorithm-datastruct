package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Test_105 {

    private static Map<Integer,Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildRootTree(preorder, 0, preorder.length - 1,inorder,0,inorder.length - 1);
    }

    /**
     * 构建根节点
     * @param preorder
     * @param preBegin
     * @param preEnd
     * @param inorder
     * @param inBegin
     * @param inEnd
     */
    private static TreeNode buildRootTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd){
        if(preBegin > preEnd){
            return null;
        }
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);
        int index  = map.get(rootVal);
        // inBegin-index 为rootVal左子树，index 到inEnd为右子树
        // 左子树数量
        int leftLength = index - inBegin;
        // 右子树数量
        int rightLength = inEnd - index;
        root.left = buildRootTree(preorder, preBegin + 1,preBegin + leftLength,inorder,inBegin,index - 1);
        root.right = buildRootTree(preorder, preBegin + leftLength + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        System.out.println(buildTree(preOrder,inOrder));
    }
}
