package com.jinyu;

import com.jinyu.node.ListNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 12:03
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Q16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 == null) curr.next = list2;
        if (list2 == null) curr.next = list1;
        return head.next;
    }

    public static void main(String[] args) {

    }
}
