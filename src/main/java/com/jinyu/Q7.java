package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 21:42
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class Q7 {
    static int result = 0;

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int f1 = 1, f2 = 1, temp = 0;
        for (int i = 2; i < n; i++) {
            temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
