package myexec.leetcode;

/**
 * 反转链表  pre 和 dummeyHead是不同的概念
 */
public class SolutionResver {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode head = new ListNode(arr);
        ListNode pre = null;
        ListNode temp;
        ListNode cur = head;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        System.out.println(pre);
    }
}
