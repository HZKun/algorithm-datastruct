package vip.qmwk.leetcode.recodeOne;

/**
 * 自定义增量栈
 *
 * @Auther: HZK
 * @Date: 2020/11/04/16:28
 * @Description:
 */
public class Test_1381 {

    public static void main(String[] args) {
        CustomStack obj = new CustomStack(3);
        System.out.println("null");
        obj.push(1);
        System.out.println("null");
        obj.push(2);
        System.out.println("null");
        int param_1 = obj.pop();
        System.out.println(param_1);
        obj.push(2);
        System.out.println("null");
        obj.push(3);
        System.out.println("null");
        obj.push(4);
        System.out.println("null");
        obj.increment(5, 100);
        System.out.println("null");
        obj.increment(2, 100);
        System.out.println("null");
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.pop();
        System.out.println(param_3);
        int param_4 = obj.pop();
        System.out.println(param_4);
        int param_5 = obj.pop();
        System.out.println(param_5);
    }


    static class CustomStack {

        private int[] data;

        private int size;

        public CustomStack(int maxSize) {
            data = new int[maxSize];
            size = 0;
        }

        public void push(int x) {
            if (size >= data.length) {
                return;
            }
            data[size] = x;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            size--;
            return data[size];
        }

        public void increment(int k, int val) {
            int lastIndex = (size - k) < 0 ? size : k;
            for (int i = 0; i < lastIndex; i++) {
                data[i] = data[i] + val;
            }
        }

        public int[] getData() {
            return data;
        }

        public void setData(int[] data) {
            this.data = data;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
