package vip.qmwk.leetcode.recodeOne;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: HZK
 * @Date: 2020/11/10/15:08
 * @Description:
 */
public class Test_232 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }

    static class MyQueue {

        private Stack<Integer> input;
        private Stack<Integer> output;

        /** Initialize your data structure here. */
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            // 先把optput到input
            while (!output.empty()){
                Integer tmp = output.pop();
                input.push(tmp);
            }
            input.push(x);
            while (!input.empty()){
                Integer tmp = input.pop();
                output.push(tmp);
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(output.empty()){
                return 0;
            }
            return output.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(output.empty()){
                return 0;
            }
            return output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return output.empty();
        }
    }
}
