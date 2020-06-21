package vip.qmwk.leetcode;

/**
 * @author hzk
 * @Description: 移除链表元素
 * @date 2020/6/22 0:12
 */
public class Test_203 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode listNode = new ListNode();
        listNode = listNode.transformArray2ListNode(arr);
        System.out.println(listNode.toString());;
        System.out.println(removeElements1(listNode,5).toString());
    }



    public static ListNode removeElements1(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode curr = head;
        while (curr.next != null){
            if(curr.next.val  == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }

}



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

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
