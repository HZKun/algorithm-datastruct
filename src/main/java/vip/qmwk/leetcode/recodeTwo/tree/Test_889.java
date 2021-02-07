package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Test_889 {

    private static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 构造树的关键是找到根节点，然后是左子树范围，右子树范围，然后递归
     * @param pre
     * @param post
     * @return
     */
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        for(int i = 0; i< post.length; i++){
            map.put(post[i], i);
        }
        return buildTreeNode(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private static TreeNode buildTreeNode(int[] pre, int preBegin, int preEnd, int[] post, int postBegin, int postEnd){
        // 跳出循环条件
        if(preBegin > preEnd){
            return null;
        }
        // 确定根节点
        int rootVal = pre[preBegin];
        TreeNode root = new TreeNode(rootVal);
        // 确定左子树范围
        // 假设左子树根节点为rootVal,即pre[1],数量为L,那么在pre中对应着preBegin + 1 ~ preBegin + 1 + L,对应到post则是:
        // post为左右根，左子树长度为L，那么左子树为postBegin ~ postBegin + L,且post[postBegin + L] = rootVal
        // 即，pre[1]为左子树根节点，post[postBegin + L]也为左子树根节点，所以L = post.indexOf(pre[1]) + 1

        // 当前节点没有子节点，即长度为0
        if(preBegin == preEnd){
            return root;
        }
        //左子树根节点
        int leftRootVal = pre[preBegin + 1];
        // 左子树长度
        int leftLength = map.get(leftRootVal) + 1;
        // 对应右子树长度
        int rightLength = preEnd - preBegin  - leftLength;
        root.left = buildTreeNode(pre, preBegin + 1, preBegin + leftLength, post, postBegin, postBegin + leftLength);
        root.right = buildTreeNode(pre, preEnd - rightLength + 1, preEnd, post, postEnd - rightLength, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        System.out.println(constructFromPrePost(pre, post));
    }
}
