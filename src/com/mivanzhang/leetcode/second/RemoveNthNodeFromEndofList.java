package com.mivanzhang.leetcode.second;

/**
 * Created by zhangmeng on 17/4/16.
 */
public class RemoveNthNodeFromEndofList {
    //只用了一次遍历,不过运行效率还是有点低
    public ListNode removeNthFromEnd(ListNode head, int n) {
        System.out.println("input head is " + head.toString());
        if (head == null) {
            return null;
        }

        ListNode firstHead = head;
        ListNode temp = new ListNode(Integer.MAX_VALUE);
        ListNode newHead = temp;
        int i = 0;
        while (firstHead != null) {
            if (i >=n) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
                head = head.next;
            }
            firstHead = firstHead.next;
            i++;
        }
        if (head.next == null) {
            return newHead.next;
        }
        temp.next =head.next;
        return newHead.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        System.out.println("input head is " + head.toString());
        if (head == null) {
            return null;
        }

        ListNode firstHead = head;
        ListNode temp =head;
        ListNode newHead = temp;
        int i = 0;
        while (firstHead != null) {
            if (i >=n) {
                head = head.next;
            }
            firstHead = firstHead.next;
            i++;
        }
        if (head.next == null) {
            return newHead.next;
        }
        temp.next =head.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        ListNode tmpNode = new ListNode(2);
        head.next = tmpNode;

        tmpNode.next = new ListNode(3);
        tmpNode = tmpNode.next;
////
//        tmpNode.next = new ListNode(4);
//        tmpNode = tmpNode.next;
//        tmpNode.next = new ListNode(9);
//        tmpNode = tmpNode.next;
////
//        tmpNode.next = new ListNode(5);
//        tmpNode = tmpNode.next;
        System.out.println("after removed   " + removeNthNodeFromEndofList.removeNthFromEnd(head, 2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + " -> " + next.toString();
        } else {
            return String.valueOf(val);
        }

    }
}