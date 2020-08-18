package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 10:25
 * <p>
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * <p>
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * 示例1
 * 输入
 * +2147'0'3647
 * 1a33
 * <p>
 * 输出
 * 2147'0'3647
 * 0
 */
public class Q49 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            if (chars[i] < '0' || chars[i] > '9') {
                if (i == 0 && (chars[i] == '-' || chars[i] == '+')) {
                    continue;
                }
                return 0;
            }
            result += (chars[i] - '0') * Math.pow(10, chars.length - i - 1);
        }
        return chars[0] == '-' ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Q49().StrToInt("-1023"));
    }
}
