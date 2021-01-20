package vip.qmwk.leetcode.recodeTwo.bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/13/15:56
 * @Description:
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

//    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        ListNode curr = this;
//        sb.append(curr.val).append("->");
//        while(curr.next != null){
//            curr = curr.next;
//            sb.append(curr.val).append("->");
//        }
//        return sb.toString();
//    }

}
