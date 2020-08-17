package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 10:32
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
public class Q12 {
    public double Power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int result = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }
        for (int i = 0; i < (-exponent); i++) {
            result *= base;
        }
        return 1.0 / result;
    }

    public static void main(String[] args) {
        System.out.println(new Q12().Power(2, -2));
    }
}
