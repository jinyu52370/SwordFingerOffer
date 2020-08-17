package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 22:31
 *
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class Q11 {
    public int NumberOf1(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int num = 0;
        for (char c : chars) {
            if (c == '1') {
                num++;
            }
        }
        return num;
    }

    public int NumberOf1I(int n) {
        return Integer.bitCount(n);
    }

        public static void main(String[] args) {
        System.out.println(new Q11().NumberOf1I(5));
    }
}
