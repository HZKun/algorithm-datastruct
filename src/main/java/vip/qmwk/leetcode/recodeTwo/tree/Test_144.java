package vip.qmwk.leetcode.recodeTwo.tree;

import vip.qmwk.leetcode.recodeTwo.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/02/03/11:14
 * @Description:
 */
public class Test_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(result, root);
        return result;
    }

    /**
     * 遍历root为根节点的
     * @param result
     * @param root
     */
    private void preOrder(List<Integer> result, TreeNode root){
        if(root == null){
            return;
        }
        result.add(root.val);
        preOrder(result, root.left);
        preOrder(result, root.right);
    }
}
