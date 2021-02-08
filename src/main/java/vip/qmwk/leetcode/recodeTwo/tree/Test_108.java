package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

public class Test_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        if(nums.length == 1){
            return new TreeNode(nums[0]);
        }
        return buildTree(0, nums.length - 1, nums);
    }

    private TreeNode buildTree(int begin, int end, int[] nums){
        if(begin > end){
            return null;
        }
        if(begin == end){
            return new TreeNode(nums[begin]);
        }
        // 中点为根节点
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(begin, mid - 1, nums);
        root.right = buildTree(mid + 1, end, nums);
        return root;
    }
}
