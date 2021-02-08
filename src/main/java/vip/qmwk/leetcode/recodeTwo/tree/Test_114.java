package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test_114 {


    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root,list);
        for(int i = 1;i<list.size();i++){
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }


}
