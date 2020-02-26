package myexec.linklist.num1;


/**
 * 本人手写代码能力薄弱,称不上程序员，只能说是复制粘贴员
 *
 * 以链表为基础 多手写代码
 * 希望成为真正的程序员，乃至于工程师
 */
public class SList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //一般来说链表知道头节点，就知道了整个链表了
    private Node head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    //返回链表的长度
    public int getSize() {
        return size;
    }

    //返回是否是空
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    //链表插入中间的关键是找到 前一节点，当在第一点时pre 就是 head
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index illegal,failed");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            Node node = new Node(e);
            node.next = pre.next;
            pre.next = node;
            size++;
        }
    }

    public void addLast(E e) {
        add(size,e);
    }
}
