package com.mivanzhang.leetcode.third;

import com.mivanzhang.leetcode.AddTwoNumbers;
import com.mivanzhang.leetcode.AddTwoNumbers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmeng on 2017/6/19.
 */
public class SwapNodeInPairs {
    /**
     * 创建一个亚节点可以更加优雅的
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp;
        ListNode prev = null;
        ListNode newHead = head.next;
        boolean isSwaped = true;
        while (head.next != null) {
            if (isSwaped) {
                isSwaped = false;
                temp = head.next;
                head.next = temp.next;
                temp.next = head;
                if (prev != null) {
                    prev.next = temp;
                }
            } else {
                prev = head;
                isSwaped = true;
                head = head.next;
            }
        }
        return newHead;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode current = dummpy;
        ListNode tmp,first,second;
        while (current.next != null && current.next.next != null) {
            first = current.next;
            second = current.next.next;
            first.next=second.next;
            second.next=first;
            current.next=second;
            current=current.next.next;
        }
        return dummpy.next;
    }


    public static void main(String[] args) {
        SwapNodeInPairs swapNodeInPairs = new SwapNodeInPairs();
        ArrayList<Integer> list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add(4);
//        list.add(5);
        System.out.println(swapNodeInPairs.swapPairs2(AddTwoNumbers.generateNode(list)));
        System.out.println(swapNodeInPairs.swapPairs2(null));

    }

}
