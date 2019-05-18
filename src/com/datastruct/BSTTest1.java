package com.datastruct;

public class BSTTest1 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num:nums)
            bst.add(num);

        //System.out.println(bst);
        /**
         *         5
         *        /  \
         *       3    6
         *      / |    \
         *     2   4    8
         */
        bst.preOrder();
        System.out.println(" ");
        bst.preOrderNR();
        System.out.println(" ");
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
        /*bst.inOrder();
        System.out.println(" ");
        bst.postOrder();*/
    }
}
