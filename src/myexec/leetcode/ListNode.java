package myexec.leetcode;


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    //以数组创造链表，注意用this
    ListNode(int[] arr) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("illegal arr");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}