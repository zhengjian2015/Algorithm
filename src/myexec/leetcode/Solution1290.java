package myexec.leetcode;

/**
 * 链表里的值 算二进制和
 *
 */
public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        ListNode cur2 = head;
        int i = 0;
        int j = 0;
        int k = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        while (cur2 != null) {
            j = (int) (j+cur2.val*(Math.pow(2,i-k-1)));
            cur2 = cur2.next;
            k++;
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        ListNode head = new ListNode(arr);
        int res = new Solution1290().getDecimalValue(head);
        System.out.println(res);
    }


}
