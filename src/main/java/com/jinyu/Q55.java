package com.jinyu;

import com.jinyu.node.ListNode;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 20:06
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Q55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode head = pHead;

        while (head != null) {
            if (list.contains(head)) {
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
