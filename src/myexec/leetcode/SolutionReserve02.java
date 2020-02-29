package myexec.leetcode;

public class SolutionReserve02 {
    public static ListNode reserve(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode res = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode h2 = reserve(head);
        System.out.println(h2);
    }
}
