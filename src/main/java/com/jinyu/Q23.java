package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 11:46
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class Q23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        //二叉树一般是用递归来做
        return dfs(sequence, 0, sequence.length - 1);
    }

    public boolean dfs(int[] sequence, int start, int end) {
        //递归结束的条件,没有节点了
        if (start >= end) {
            return true;
        }
        //end处是根节点，要充分利用二叉搜索树的特点“左边<根<右边”；后续遍历是：左、右、根，可以把遍历顺序中的左右树分出来
        int tempIndex = start;
        while (sequence[tempIndex] < sequence[end]) {
            tempIndex++;
        }
        //找到了分界点，此时游标在右子树开始处
        int midIndex = tempIndex;
        //继续往右走，看看右子树满不满足“根<右边”的规律
        while (sequence[tempIndex] > sequence[end]) {
            tempIndex++;
        }
        //跳出循环，表示走到了>=根的地方;判断完整个树大致“有序”，还要看左右子树是否正确
        return (tempIndex == end) && dfs(sequence, start, midIndex - 1) && dfs(sequence, midIndex, end - 1);//注意注意!!!end-1
    }

    public static void main(String[] args) {

    }
}
