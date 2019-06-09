package leetcode;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 21题 是简单题
 */
public class Solution21 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] arr2 = {1,2,3,9,10,222,33};
        ListNode node = new ListNode(arr);
        ListNode node2 = new ListNode(arr2);
        //System.out.println(node);
        ListNode node3 = new Solution21().mergeTwoLists(node,node2);
        ListNode node4 = new Solution21().mergeTwoLists2(node,node2);
        System.out.println(node3);
        System.out.println(node4);
    }

    /**
     * 我的想法是 取值合成新的数组
     * 重新创造1个链表，解体里是不行的，现实中估计可以
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        long begin2 = System.nanoTime();
        List<Integer> arr = new ArrayList<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null) {
            arr.add(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            arr.add(cur2.val);
            cur2 = cur2.next;
        }
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                if (lhs > rhs) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        //System.out.println(arr);
        int[] re = new int[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            re[j] = arr.get(j);
        }
        ListNode res = new ListNode(re);
        long end2 = System.nanoTime();
        double time2 = (end2 - begin2)/1000000000.0;
        System.out.println("mergeTwoLists用时"+time2+"s");
        return res;
    }


    /**
     *  参考答案 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {

        return l1;
    }

    /**
     *  参考答案 迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        long begin2 = System.nanoTime();
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;
        long end2 = System.nanoTime();
        double time2 = (end2 - begin2)/1000000000.0;
        System.out.println("mergeTwoLists2用时"+time2+"s");
        return prehead.next;

    }

}
