package vip.qmwk.datastruct.set;

/**
 * @author hzk
 * @Description: 集合Set
 * @date 2020/6/23 23:49
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();

}
