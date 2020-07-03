package vip.qmwk.datastruct.tree;
import	java.util.LinkedList;
import	java.util.Queue;
/**
 * @author hzk
 * @Description: 二分搜索树
 * @date 2020/6/23 23:41
 */
public class BST<E extends Comparable <E>>  {

    private class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e){
            this.e = e;
            left = right = null;
        }

        @Override
        public String toString(){
            return "Node:" + e;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e){
        if(root == null){
            root = new Node(e);
            size ++;
        } else {
            add(root, e);
        }
    }

    public boolean contains(E e){
        if(root == null){
            return false;
        }
        return contains(root, e);
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        levelOrder(root);
    }

    /**
     * 查找最小值
     * @return
     */
    public Node findMin(){
        return findMin(root);
    }

    public Node findMax(){
        return findMax(root);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，返回值为void
     * @param node
     * @param e
     */
    private void add(Node node, E e){
        if(e.equals(node.e)){
            return;
        }else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }
        if(e.compareTo(node.e) < 0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，返回值为node
     * @param node
     * @param e
     * @return
     */
    private Node addNode(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(node.e.compareTo(e) < 0){
            node.right = addNode(node.right, e);
        }else if(node.e.compareTo(e) > 0){
            node.left = addNode(node.left, e);
        }
        return node;
    }

    /**
     * 以node为根节点的树中是否包含元素e
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if(node.e.equals(e)){
            return true;
        }else if(node.e.compareTo(e) < 0){
            return contains(node.right,e);
        }else{
            return contains(node.left,e);
        }
    }

    /**
     * 遍历以root根节点的树
     */
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 遍历以root根节点的树
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 遍历以root根节点的树
     */
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     * @param node
     */
    private void levelOrder(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node> ();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left != null){
                queue.offer(node.left);
            }
            if(cur.right != null){
                queue.offer(node.right);
            }
            System.out.println(cur.e);
            node = queue.peek();
        }
    }

    /**
     * 查找最小值
     * @param node
     */
    public Node findMin(Node node){
        if(node == null){
            return null;
        }
        if(node.left != null){
            findMin(node.left);
        }
        return node;
    }

    /**
     * 查找最大值
     * @param node
     * @return
     */
    public Node findMax(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            findMax(node.right);
        }
        return node;
    }

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(3);
        tree.add(6);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        System.out.println("中序遍历");
        tree.inOrder();
        System.out.println("前序遍历");
        tree.preOrder();
        System.out.println("后序遍历");
        tree.postOrder();
        System.out.println("层序遍历");
        tree.levelOrder();
    }











}
