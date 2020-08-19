package com.jinyu;

import com.jinyu.node.TreeNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 9:22
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 二叉树的序列化是指：
 * 把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 */
public class Q61 {
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuilder builder = new StringBuilder();
        pre(root, builder);
        return builder.toString();
    }

    void pre(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#!");
            return;
        }
        builder.append(root.val).append("!");
        pre(root.left, builder);
        pre(root.right, builder);
    }

    TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        return dePre(str.split("!"));
    }

    int index = -1;

    public TreeNode dePre(String[] strs) {
        index++;
        if (!"#".equals(strs[index])) {
            TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = dePre(strs);
            node.right = dePre(strs);
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
