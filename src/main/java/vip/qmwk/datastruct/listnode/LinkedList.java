package vip.qmwk.datastruct.listnode;

/**
 * 链表
 *
 * @Auther: HZK
 * @Date: 2020/08/25/20:14
 * @Description:
 */
public class LinkedList<E> {

    private int size;
    private Node<E> head;

    private static class Node<E>{
        E e;
        Node next;

        public Node() {
        }

        Node(E e) {
            this.e = e;
            next = null;
        }

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    public LinkedList() {
        size = 0;
        head = null;
    }

    public LinkedList(int size, Node<E> head) {
        this.size = size;
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void addNode(E e){
        if (head == null){
            head = new Node<>(e);
        }else{
            while (head.next != null){
                head = head.next;
            }
            head.next = new Node(e);
        }
        size++;
    }

    @Override
    public String toString(){
        if(head == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.e).append("->");
            head = head.next;
        }
        return sb.toString().substring(0,sb.length() - 1);
    }
}




