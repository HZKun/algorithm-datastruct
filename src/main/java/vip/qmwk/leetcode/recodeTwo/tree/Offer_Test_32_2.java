package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Offer_Test_32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 1;

        while(!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int nextCount = 0;
            while(count > 0){
                TreeNode treeNode = queue.poll();
                tempList.add(treeNode.val);
                count--;
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                    nextCount++;
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                    nextCount++;
                }
            }
            count = nextCount;
            result.add(tempList);
        }
        return result;
    }
}
