package vip.qmwk.leetcode.recodeTwo.tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/02/03/14:48
 * @Description:
 */
public class Offer_Test_33 {

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,6,9,4,3};
        System.out.println(verifyPostorder(arr));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return isPostorderTree(postorder, 0, postorder.length - 1);
    }


    private static boolean isPostorderTree(int[] postorder, int begin, int end){
        if(begin >= end - 1){
            return true;
        }
        boolean result = true;
        int mid = begin;
        // 获取第一个大于根节点的index，index前面都为左子树，后面为右子树
        int rootVal = postorder[end];
        while(postorder[mid] < rootVal){
            mid++;
        }
        // 从begin到mid都要小于根节点,由于上面while循环保证了肯定小于根节点(获取的第一个大于根节点的index),所以只考虑右子树
        // 右子树，mid到end大于根节点
        int curr = mid;
        while(curr < end){
            if(postorder[curr] > postorder[end]){
                    curr++;
            }else{
                return false;
            }
        }
        // 判断左右子树是否符合
        boolean left = isPostorderTree(postorder, begin, mid - 1);
        boolean right = isPostorderTree(postorder, mid, end - 1);
        result = left & right;

        return result;
    }
}
