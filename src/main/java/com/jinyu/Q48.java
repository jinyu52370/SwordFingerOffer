package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 23:47
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Q48 {
    public int Add(int num1, int num2) {
        int result;
        int ans;
        do {
            result = num1 ^ num2;
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }

    public static void main(String[] args) {

    }
}
