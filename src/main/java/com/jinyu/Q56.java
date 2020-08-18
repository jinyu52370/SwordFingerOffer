package com.jinyu;

import com.jinyu.node.ListNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 20:20
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Q56 {
//    public ListNode deleteDuplication(ListNode pHead) {
//        if (pHead == null || pHead.next == null) {
//            return pHead;
//        }
//        while (pHead.next != null) {
//            if (pHead.val == pHead.next.val) {
//                pHead = pHead.next;
//            }
//        }
//
//        ListNode slow = new ListNode(-1);
//        slow.next = pHead;
//        ListNode fast = pHead.next;
//
//        while (fast != null) {
//            if (slow.next.val == fast.val) {
//                slow.next = fast.next;
//                fast = slow.next.next;
//                continue;
//            }
//            slow = slow.next;
//            fast = fast.next;
//        }
//        return pHead;
//    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        LinkedHashMap<Integer, ListNode> map = new LinkedHashMap<>();
        ListNode head = pHead;
        while (head != null) {
            map.put(head.val, map.containsKey(head.val) ? null : head);
            head = head.next;
        }

        ArrayList<ListNode> list = new ArrayList<>();

        for (Integer key : map.keySet()) {
            if (map.get(key) != null) {
                list.add(map.get(key));
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        if (list.isEmpty()) {
            return null;
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        new Q56().deleteDuplication(node1);
    }
}
