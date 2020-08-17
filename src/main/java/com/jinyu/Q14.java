package com.jinyu;

import com.jinyu.node.ListNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 11:30
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Q14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            //防止k大于链表长度
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
