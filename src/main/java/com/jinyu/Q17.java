package com.jinyu;

import com.jinyu.node.TreeNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 13:14
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Q17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        //只有当两个二叉树都不为空时，才可以进行比较，否则直接返回false
        if (root1 != null && root2 != null) {
            //从root1树中的根节点开始遍历，与root2的根节点值进行比较判断，如果相等的话
            if (root1.val == root2.val) {
                //以这个根节点的为起点判断root1是否包含root2
                res = doesRoot1HasRoot2(root1, root2);
            }
            //如果找不到，那么就再去root1的左儿子当作起点，去判断时候包含root2
            if (!res) {
                //从root1的左子树开始查找是否含有root2
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                //从root1的右子树开始查找是否含有root2
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    private boolean doesRoot1HasRoot2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            //root2树已经遍历完，匹配成功
            return true;
        }
        if (root1 == null) {
            //root1树遍历完，而root2还没遍历结束
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesRoot1HasRoot2(root1.left, root2.left) && doesRoot1HasRoot2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        TreeNode subNode1 = new TreeNode(1);
        TreeNode subNode8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node7;
        node3.left = node5;
        node3.right = node6;

        subNode1.right = subNode8;

        System.out.println(new Q17().HasSubtree(node1, subNode1));
    }
}
