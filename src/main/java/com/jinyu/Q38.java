package com.jinyu;

import com.jinyu.node.TreeNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 18:30
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Q38 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth, rightDepth;
        leftDepth = 1 + TreeDepth(root.left);
        rightDepth = 1 + TreeDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(11);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node3 = new TreeNode(3);
        TreeNode node10 = new TreeNode(10);
        TreeNode node19 = new TreeNode(19);
        TreeNode node40 = new TreeNode(40);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node36 = new TreeNode(36);
        TreeNode node100 = new TreeNode(100);

        node11.left = node9;
        node11.right = node20;
        node9.left = node3;
        node9.right = node10;
        node3.left = node1;
        node3.right = node5;
        node20.left = node19;
        node20.right = node40;
        node40.left = node36;
        node40.right = node100;

        System.out.println(new Q38().TreeDepth(node11));
    }
}
