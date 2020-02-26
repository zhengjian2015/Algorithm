package myexec.leetcode;


/**
 * 这次的经验是 一个cur 遍历到最后就是null 了，不要重复使用
 *
 * 我的思路是先走一遍得到长度，再反推正向长度
 * 参考答案说是 快慢指针，不过我这个也挺快的啊
 */
public class Solutionit22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead.next;
        ListNode cur2 = dummyHead.next;
        while (cur1 != null) {
            size++;
            cur1 = cur1.next;
        }
        int k2 = size - k;
        for (int i = 0; i < k2; i++) {
            cur2 = cur2.next;
        }
        return cur2;
    }
    public static void main(String[] args) {
        int[] arrs = {1,2,3,4,5};
        ListNode head = new ListNode(arrs);
        System.out.println(new Solutionit22().getKthFromEnd(head,2));
    }
}
