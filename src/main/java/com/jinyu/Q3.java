package com.jinyu;



import com.jinyu.node.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 16:59
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Q3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = listNode;
        ArrayList<Integer> listSource = new ArrayList<>();

        while (head != null) {
            listSource.add(head.val);
            head = head.next;
        }
        listSource.sort(Comparator.reverseOrder());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < listSource.size(); i++) {
            list.add(listSource.get(i));
        }
        return list;
    }

    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ListNode curr = listNode;
        ListNode next;
        ListNode reversedHead = new ListNode(-1);

        while (curr != null) {
            next = curr.next;
            curr.next = reversedHead.next;
            reversedHead.next = curr;
            curr = next;
        }
        ListNode head = new ListNode(-1);
        head.next = reversedHead.next;

        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        if(listNode!=null){
            printListFromTailToHead2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(printListFromTailToHead2(node1));
    }
}
