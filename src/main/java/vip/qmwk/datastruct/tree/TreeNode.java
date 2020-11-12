package vip.qmwk.datastruct.tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/12/11:54
 * @Description:
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
