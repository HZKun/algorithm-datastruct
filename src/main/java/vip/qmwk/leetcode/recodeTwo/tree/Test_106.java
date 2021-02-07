package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Test_106 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildRootTree(inorder,0,inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildRootTree(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (postBegin > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        // inBegin ~ index 左子树， index ~ inEnd 右子树
        int leftLength = index - inBegin;
        int rightLength = inEnd - index;
        root.left = buildRootTree(inorder, inBegin, index - 1, postorder, postBegin, postBegin + leftLength - 1);
        root.right = buildRootTree(inorder, index + 1, inEnd, postorder, postEnd - rightLength, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        System.out.println(buildTree(inOrder, postorder));
    }
}
