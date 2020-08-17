package com.jinyu;

import com.jinyu.node.TreeNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 19:59
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class Q39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null ) {
            return true;
        }
        return Math.abs(recursion(root.left) - recursion(root.right)) <= 1;
    }

    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth, rightDepth;
        leftDepth = 1 + recursion(root.left);
        rightDepth = 1 + recursion(root.right);
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

        System.out.println(new Q39().IsBalanced_Solution(node11));
    }
}
