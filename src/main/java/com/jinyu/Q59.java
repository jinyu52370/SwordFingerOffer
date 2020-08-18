package com.jinyu;

import com.jinyu.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 22:43
 * <p>
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Q59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean reverse = false;
        ArrayList<Integer> list;

        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (!reverse) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);//每次加到0的位置，就自动逆序了
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (list.size() > 0) {
                result.add(list);
                reverse = !reverse;
            }
        }
        return result;
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

        System.out.println(new Q59().Print(node11));
    }
}
