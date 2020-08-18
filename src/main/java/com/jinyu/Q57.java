package com.jinyu;

import com.jinyu.node.TreeLinkNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 21:13
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Q57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //若结点有右子树，则中序遍历的下一个结点为其右子树的最左叶子结点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        while (pNode.next != null) {
            // 父亲节点的左节点等于本身，且本身没有右节点，那么直接返回父节点
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            // 父亲节点的左节点不等于本身，说明本身在父节点的右子节点，继续遍历父亲节点的父节点
            pNode = pNode.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
