package com.jinyu;

import com.jinyu.node.RandomListNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 12:48
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Q25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        //复制原链表
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        //复制random指针
        node = pHead;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        //拆分原链表和新链表
        node = pHead;
        RandomListNode root = pHead.next;
        RandomListNode tmp = root;
        while (node != null) {
            node.next = tmp.next;
            tmp.next = node.next == null ? null : node.next.next;
            node = node.next;
            tmp = tmp.next;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
