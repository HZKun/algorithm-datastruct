package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/02/03/11:29
 * @Description:
 */
public class Test_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(result, root);
        return result;
    }

    private void inOrder(List<Integer> result, TreeNode root){
        if(root == null){
            return;
        }
        inOrder(result, root.left);
        result.add(root.val);
        inOrder(result, root.right);
    }
}
