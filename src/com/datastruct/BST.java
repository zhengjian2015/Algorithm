package com.datastruct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树有天然的递归结构
 * 每个节点的左子树也是二叉树
 * 每个节点的右子树也是二叉树
 * 二叉树不一定是满的， 都是满的叫满二叉树
 * NULL也是 二叉树
 * 二分搜索树 的每个节点的值
 * 大于其左子树的所有节点的值
 * 小于其右子树的所有节点的值
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right; //分别指向它的左孩子和右孩子

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** 向二分搜索树中插入1个新元素
     * 从根元素依次比较比它大就去右子树
     * 比它小就去左孩子，如果相等就不处理
     */
    /*
    public void add(E e) {
        if(root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root,e);
        }
    }

    //向以node为根节点的二分搜索树中插入元素e,递归算法
    //最初版本好理解，需要改进，更简洁
    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if(e.compareTo(node.e) >0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        } else if(e.compareTo(node.e) < 0) {
            add(node.left,e);
        } else { //e.compareTo(node.e) > 0
            add(node.right,e);
        }
    }
    */

    /**
     * 改进的插入需要理解是 NULL也是1个二叉树
     */
    public void add(E e) {
       root = add(root,e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        //如果不接住返回的值，返回的node就依然是左右为null的二叉树
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }
    /**
     * 二分搜索树的前序遍历
     * 所谓的前序就是 先访问节点再访问左右节点
     */
    public void preOrder() {
        preOrder(root);
    }

    //以node为根的二分搜索树，遵循先写递归终止的条件，再写组成逻辑
    //更小规模的解组成更多的解
    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归的前序遍历 利用栈来实现
     * 比递归的实现要难很多，需要借助辅助数据结构
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 二分搜索树的中序遍历 也是顺序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){

        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 广度优先遍历，也称为层序遍历，先遍历第o层，再遍历第1层
     * @return
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if(node.right == null)
            return node;
        return maximum(node.right);
    }

    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在的节点，返回最小值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 计算机科学Hibbard 1962年提出的方法
     * 删除任意节点的值 当这个节点有左右孩子时
     * 找出改节点右孩子为根的最小值，替换要删的点即可
     *
     * @return
     */
    public E remove(E e) {
        root = remove(root,e);
        return e;
    }

    //删除掉以node为根的二分搜索树中的节点
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        //递归到底没找到要删除的元素
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0) {
            node.left  = remove(node.left,e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else { //e == node.e
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode; //我纠结的删除元素怎么并回去，是上层有地方接收
            }
            //删除右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //后继节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    /** ceil 和 floor 比这数最小的数 和最大的数 地板和天花板
     *  rank select  还有支持重复元素的树
     * 二分搜索树对应的形状可能有区别
     * 比如 1，2，3，4，5，6 极端情况 就是个链表
     * 为了预防这种情况 产生了平衡二叉树 其中红黑树就是这个的实现
     */
}
