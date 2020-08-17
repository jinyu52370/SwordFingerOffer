package com.jinyu;

import com.jinyu.node.ListNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 11:47
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Q15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode reversedHead = new ListNode(-1);
        ListNode curr = head;
        ListNode next;
        while (curr != null){
            next = curr.next;
            curr.next = reversedHead.next;
            reversedHead.next = curr;
            curr = next;
        }
        return reversedHead.next;
    }

    public static void main(String[] args) {

    }
}
