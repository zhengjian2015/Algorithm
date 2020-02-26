package myexec.leetcode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Solutionit18 {
    public ListNode deleteNode(ListNode head, int val) {
        //设置虚拟头结点 就不用考虑head的特别情况
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            ListNode delNode = prev.next;
            if(delNode.val == val) {
                prev.next = delNode.next;
                delNode.next = null;
            }
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arrs = {2,3,4,5};
        ListNode nodes = new ListNode(arrs);
        System.out.println(nodes);
        ListNode head = new Solutionit18().deleteNode(nodes,6);
        System.out.println(head);
    }


}
