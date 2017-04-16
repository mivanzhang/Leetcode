package com.mivanzhang.leetcode.second;

import java.util.Random;

/**
 * Created by zhangmeng on 17/4/16.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        System.out.println("intput two list is l1 "+l1+" \nl2  "+l2+"  ");
        ListNode newNode = new ListNode(Integer.MIN_VALUE);
        ListNode tempNode = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        if (l1 != null) {
            tempNode.next = l1;
        }
        if (l2 != null) {

            tempNode.next = l2;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists=new MergeTwoSortedLists();
        System.out.println("merged result is "+mergeTwoSortedLists.mergeTwoLists(mergeTwoSortedLists.createListNode(6),mergeTwoSortedLists.createListNode(2)));
        System.out.println("merged result is "+mergeTwoSortedLists.mergeTwoLists(mergeTwoSortedLists.createListNode(6),mergeTwoSortedLists.createListNode(2)));
    }

    private ListNode createListNode(int root) {
        ListNode head = new ListNode(1);
        ListNode tmpNode = new ListNode(2);
        head.next = tmpNode;
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10); i++) {
            tmpNode.next = new ListNode(i+root);
            tmpNode = tmpNode.next;
        }
        return head;
    }
}

