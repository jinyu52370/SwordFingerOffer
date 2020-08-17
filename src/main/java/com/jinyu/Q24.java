package com.jinyu;

import com.jinyu.node.TreeNode;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 12:16
 * <p>
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Q24 {
    private final ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        FindPath(root, target, new ArrayList<>());
        return resultList;
    }

    public void FindPath(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
        } else {
            FindPath(root.left, target, list);
            FindPath(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node7;
        node3.left = node5;
        node3.right = node6;
        node6.left = node8;

        System.out.println(new Q24().FindPath(node1, 18));
    }
}
