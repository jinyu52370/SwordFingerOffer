package com.jinyu;

import com.jinyu.node.ListNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 18:01
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Q36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        node4.next = node2;

        new Q36().FindFirstCommonNode(node1, node4);
    }
}
