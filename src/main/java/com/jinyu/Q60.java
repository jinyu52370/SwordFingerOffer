package com.jinyu;

import com.jinyu.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 0:09
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Q60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        while (!queue.isEmpty()) {

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
