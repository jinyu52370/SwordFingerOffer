package com.jinyu;

import com.jinyu.node.TreeNode;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 13:23
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Q26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree, list);
        return Convert(list);
    }

    //中序遍历，在list中按遍历顺序保存
    public void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list) {
        if (pRootOfTree.left != null) {
            Convert(pRootOfTree.left, list);
        }

        list.add(pRootOfTree);

        if (pRootOfTree.right != null) {
            Convert(pRootOfTree.right, list);
        }
    }

    //遍历list，修改指针
    public TreeNode Convert(ArrayList<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
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

        new Q26().Convert(node11, new ArrayList<>());
    }
}
