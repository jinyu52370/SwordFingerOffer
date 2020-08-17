package com.jinyu;

import com.jinyu.node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 10:54
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Q22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty()){
            list.add(linkedList.pop().val);
            if (root.left != null) {
                linkedList.add(root.left);
            }if (root.right != null) {
                linkedList.add(root.right);
            }
            if (!linkedList.isEmpty()) {
                root = linkedList.peek();
            }
        }
        return list;
    }

//    public void count(TreeNode root, int depth) {
//        if (root == null || depth < 0) {
//            return;
//        }
//        if (depth == 0) {
//            num++;
//            return;
//        }
//        count(root.left, depth - 1);
//        count(root.right, depth - 1);
//    }

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

        System.out.println(new Q22().PrintFromTopToBottom(node1));
    }
}
