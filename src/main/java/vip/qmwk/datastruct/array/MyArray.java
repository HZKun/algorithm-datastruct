package vip.qmwk.datastruct.array;

import java.util.Arrays;

/**
 * @author hzk
 * @Description: 自定义数组
 * @date 2020/6/11 23:18
 */
public class MyArray<E> {

    private E[] data;
    private int size;   // 元素个数

    //无参数构造，默认给10
    public MyArray() {
        this(10);
    }

    public MyArray(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 获取数组中元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在最后添加一个新元素
    public void addLast(E e){
        add(size,e);
    }

    // 在第index插入一个新元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引异常！");
        }
        if(size == data.length){
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引异常！");
        }
        return data[index];
    }

    // 设置index元素为e
    public void set(int index ,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引异常！");
        }
        data[index] = e;
    }

    // 是否包含某个元素
    public boolean contains(E e){
        for (int i = 0;i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查询某个元素的索引
    public int find(E e){
        for (int i = 0;i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 删除某个元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引异常！");
        }
        E tmp = (E)data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length/2){
            resize(data.length/2);
        }
        return tmp;
    }

    // 删除某个元素(第一次出现的)
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + data.length +
                '}';
    }
}
