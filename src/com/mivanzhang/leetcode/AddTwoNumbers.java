package com.mivanzhang.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangmeng on 17/3/12.
 * pass
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        extra = (l1.val + l2.val) / 10;
        ListNode current = result;
        while (l1.next != null || l2.next != null||extra!=0) {
//            l1 = getNextNode(l1);
//            l2 = getNextNode(l2);
            l1=l1.next == null?new ListNode(0):l1.next;
            l2=l2.next == null?new ListNode(0):l2.next;
            ListNode newNode = new ListNode((l1.val + l2.val + extra) % 10);
            extra = (l1.val + l2.val + extra) / 10;
            current.next = newNode;
            current = newNode;
        }
        return result;
    }

    private ListNode getNextNode(ListNode listNode) {
        if (listNode.next == null) {
            listNode.next = new ListNode(0);
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers instance = new AddTwoNumbers();
//        ListNode l1 = instance.generateNode(Arrays.asList(4,9,9,9,1));
        ListNode l1 = instance.generateNode(Arrays.asList(0,9,1,4,5,3,0,5,9));
        ListNode l2 = instance.generateNode(Arrays.asList(5,4,4,4,9,3,3,2,8,1));
//        ListNode l2 = instance.generateNode(Arrays.asList(7, 9, 6));
        System.out.println("l1  " + l1);
        System.out.println("l2  " + l2);
        System.out.println("re  "+instance.addTwoNumbers(l1, l2));
    }

    public ListNode generateNode(List<Integer> list) {
        ListNode l1 = new ListNode(list.get(0));
        ListNode current = l1;
        for (int i = 1; i < list.size(); i++) {
            ListNode last = new ListNode(list.get(i));
            current.next = last;
            current = last;
        }
        return l1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + " " + next.toString();
            }
            return val + " ";
        }
    }
}
