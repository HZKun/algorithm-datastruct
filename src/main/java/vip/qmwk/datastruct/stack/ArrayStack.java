package vip.qmwk.datastruct.stack;

import vip.qmwk.datastruct.array.MyArray;

/**
 * @author hzk
 * @Description: 数组实现栈
 * @date 2020/6/21 23:09
 */
public class ArrayStack<E> implements Stack<E>{

    MyArray<E> array;

    public ArrayStack(int capacity) {
        array = new MyArray<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.remove(array.getSize() - 1);
    }

    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.getSize();i++){

        }
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}
