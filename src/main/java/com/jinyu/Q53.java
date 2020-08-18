package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 17:16
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Q53 {
    public boolean isNumeric(char[] str) {

        if (str.length == 0) {
            return false;
        }
        if (str.length == 1) {
            if (str[0] < '0' || str[0] > '9') {
                return false;
            }
        }

        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            //判断e/E是否出现过
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) {
                    return false;
                } // e后面一定要接数字
                if (hasE) {
                    return false;
                }  // 不能同时存在两个e
                hasE = true;
                continue;
            }
            //判断+/-是否出现过
            if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                sign = true;
                continue;
            }
            //判断.是否出现过
            if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
                continue;
            }
            //判断合法字符
            if (str[i] < '0' || str[i] > '9') {// 不合法字符
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q53().isNumeric("123.45e+6".toCharArray()));
    }
}
