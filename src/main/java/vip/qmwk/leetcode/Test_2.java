package vip.qmwk.leetcode;

import java.util.List;

/**
 * @author hzk
 * @Description: 两数相加
 * @date 2020/8/24 23:34
 */
public class Test_2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 9;
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode();
        l2.val = 0;

        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(addTwoNumbers(l1,l2).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode result = new ListNode();
        addNum(l1,l2,result,false);
        return result;
    }

    public static void addNum(ListNode l1, ListNode l2, ListNode result, boolean addOne){
        if(l1 == null || l2 == null){
            if(l1 == null && l2 != null){
                result.val = addOne?l2.val+1:l2.val;
                if(result.val >= 10){
                    result.val = result.val - 10;
                    result.next = new ListNode();
                    addNum(null,l2.next,result.next,true);
                }else{
                    if(l2.next != null){
                        result.next = new ListNode();
                    }
                    addNum(null,l2.next,result.next,false);
                }
                return;
            }else if(l1 != null){
                result.val = addOne?l1.val+1:l1.val;
                if(result.val >= 10){
                    result.val = result.val - 10;
                    result.next = new ListNode();
                    addNum(l1.next,null,result.next,true);
                }else{
                    if(l1.next != null){
                        result.next = new ListNode();
                    }
                    addNum(l1.next,null,result.next,false);
                }
                return;
            }else{
                if(addOne){
                    result.val = 1;
                }
                return;
            }
        }
        int num1 = l1.val;
        int num2 = l2.val;
        if(addOne){
            if(num1 + num2 + 1 >= 10){
                result.val = num1 + num2 + 1 - 10;
                addOne = true;
            }else{
                result.val = num1 + num2 + 1;
                addOne = false;
            }
        }else{
            if(num1 + num2 >= 10){
                result.val = num1 + num2 - 10;
                addOne = true;
            }else{
                result.val = num1 + num2;
                addOne = false;
            }
        }
        l1 = l1.next;
        l2 = l2.next;
        if(l1 != null || l2 != null || addOne){
            result.next = new ListNode();
        }
        addNum(l1,l2,result.next,addOne);
    }
}


