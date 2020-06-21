package vip.qmwk.datastruct.stack;

/**
 * @author hzk
 * @Description: 栈接口
 * @date 2020/6/21 23:10
 */
public interface Stack<E> {

    public int getSize();

    public boolean isEmpty();

    /**
     * 进栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 栈顶元素
     * @return
     */
    E peek();
}
