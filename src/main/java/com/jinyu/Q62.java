package com.jinyu;

import com.jinyu.node.TreeNode;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 15:12
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class Q62 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        ArrayList<TreeNode> list = new ArrayList<>();
        recursion(pRoot, list);
        return k <= list.size() && k > 0 ? list.get(k - 1) : null;
    }

    private void recursion(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        recursion(root.left, list);
        list.add(root);
        recursion(root.right, list);
    }


    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);

        node8.left = node6;
        node8.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;

        System.out.println(new Q62().KthNode(node8, 0).val);
    }
}
