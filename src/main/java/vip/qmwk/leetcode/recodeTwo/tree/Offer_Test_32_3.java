package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.datastruct.stack.ArrayStack;
import vip.qmwk.datastruct.stack.Stack;
import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Offer_Test_32_3 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(levelOrder(treeNode1));
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        List<TreeNode> currList = new ArrayList<>();
        List<TreeNode> nextList = new ArrayList<>();
        currList.add(root);
        while(!currList.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            // 封装当前行
            for(int i = 0; i<currList.size();i++){
                temp.add(currList.get(i).val);

            }
            for(int i = currList.size()-1; i>=0;i--){
                TreeNode tempNode = currList.get(i);
                if(level%2 == 0){
                    if(tempNode.right != null){
                        nextList.add(tempNode.right);
                    }
                    if(tempNode.left != null){
                        nextList.add(tempNode.left);
                    }
                }else{
                    if(tempNode.left != null){
                        nextList.add(tempNode.left);
                    }
                    if(tempNode.right != null){
                        nextList.add(tempNode.right);
                    }
                }
            }
            currList.clear();
            currList.addAll(nextList);
            nextList.clear();
            level++;
            result.add(temp);
        }
        return result;
    }

}
