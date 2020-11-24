package vip.qmwk.leetcode.recodeOne.bean;

/**
 * ListNode.
 *
 * @Auther: HZK
 * @Date: 2020/08/25/11:22
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode random;
    public ListNode(int x) { val = x; }

    public ListNode(){};

    public ListNode transformArray2ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        val = arr[0];
        ListNode curr = this;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while(curr != null){
            sb.append(curr.val).append("->");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
