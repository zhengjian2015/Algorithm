package com.leetcode;


import com.datastruct.LinkedList;

/**
 * 203
 */
public class delListNode {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(6);
        list.addFirst(5);
        System.out.println(list.getSize());
        System.out.println(list);

    }

  /*  public static LinkedList.Node removeElemets(LinkedList.Node head, int val) {
        if((int)head.e == val) {
            LinkedList.Node delNode = head;
            head = head.next;
            delNode.next = null;
        }
        return head;
    }*/
}
