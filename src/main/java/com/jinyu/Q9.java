package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 22:11
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Q9 {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        int[] a = new int[target + 1];
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            a[i] = sum + 1;
            sum += a[i];
        }
        return a[target];
    }

    public int JumpFloorII1(int target) {
        return 1 << (target - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Q9().JumpFloorII1(10));
    }
}
