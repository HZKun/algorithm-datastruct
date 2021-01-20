package vip.qmwk.leetcode.recodeTwo.linked;

import vip.qmwk.leetcode.recodeTwo.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2021/01/20/17:33
 * @Description:
 */
public class Test_148 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(sortList(l1));
    }

    public static ListNode sortList(ListNode head) {
        int length = listLength(head);
        ListNode res = new ListNode(Integer.MIN_VALUE, head);

        for (int intv = 1; intv < length; intv *= 2) {
            ListNode prev = res;
            ListNode h = res.next;
            while (h != null) {
                // BEGIN get the two merge head `h1`, `h2`
                ListNode h1 = h, h2 = null;
                int i = intv;
                while (i != 0 && h != null) {
                    h = h.next;
                    i -= 1;
                }
                // no need to merge because the `h2` is None.
                if (i != 0) break;
                h2 = h;
                // END get the two merge head `h1`, `h2`

                // get next h
                i = intv;
                while (i != 0 && h != null) {
                    h = h.next;
                    i -= 1;
                }

                //BEGIN merge the `h1` and `h2`.
                int c1 = intv, c2 = intv - i;   // the `c2`: length of `h2` can be small than the `intv`.
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        prev.next = h1;
                        h1 = h1.next;
                        c1 -= 1;
                    } else {
                        prev.next = h2;
                        h2 = h2.next;
                        c2 -= 1;
                    }
                    prev = prev.next;
                }
                prev.next = c1 > 0 ? h1 : h2;
                // END merge the `h1` and `h2`

                // let prev be the node before h
                while (c1-- > 0 || c2-- > 0) prev = prev.next;
                prev.next = h;
            }
        }
        return res.next;
    }

    /**
     * 计算链表长度
     */
    private static int listLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length += 1;
            head = head.next;
        }
        return length;
    }

}