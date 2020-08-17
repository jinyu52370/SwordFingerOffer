package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 21:54
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Q8 {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int j1 = 1, j2 = 2, temp = 0;
        for (int i = 3; i <= target; i++) {
            temp = j1 + j2;
            j1 = j2;
            j2 = temp;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
