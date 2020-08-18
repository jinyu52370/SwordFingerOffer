package com.jinyu;

import com.jinyu.node.TreeNode;


/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 21:41
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Q58 {
    /*
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        ArrayList<Integer> leftPreList = new ArrayList<>();
        ArrayList<Integer> leftMidList = new ArrayList<>();
        ArrayList<Integer> rightPreList = new ArrayList<>();
        ArrayList<Integer> rightMidList = new ArrayList<>();

        reversed(pRoot.right);

        pre(pRoot.left, leftPreList);
        mid(pRoot.left, leftMidList);

        pre(pRoot.right, rightPreList);
        mid(pRoot.right, rightMidList);

        if (leftPreList.size() != rightPreList.size() || leftMidList.size() != rightMidList.size()) {
            return false;
        }
        for (int i = 0; i < leftPreList.size(); i++) {
            if (!leftPreList.get(i).equals(rightPreList.get(i))) {
                return false;
            }
        }
        for (int i = 0; i < leftMidList.size(); i++) {
            if (!leftMidList.get(i).equals(rightMidList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void pre(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        pre(root.left, list);
        pre(root.right, list);
    }

    public void mid(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        mid(root.left, list);
        list.add(root.val);
        mid(root.right, list);
    }

    public void reversed(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reversed(root.left);
        reversed(root.right);
    }
     */

    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || recursion(pRoot.left, pRoot.right);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
