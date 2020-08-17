package com.jinyu;

import com.jinyu.node.TreeNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 20:21
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Q18 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node7;
        node3.left = node5;
        node3.right = node6;

        new Q18().Mirror(node1);

        System.out.println(123);
    }
}
