package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/02/03/11:33
 * @Description:
 */
public class Test_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(result, root);
        return result;
    }

    private void postOrder(List<Integer> result, TreeNode root){
        if(root == null){
            return;
        }
        postOrder(result, root.left);
        postOrder(result, root.right);
        result.add(root.val);
    }
}
