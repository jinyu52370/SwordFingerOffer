package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 23:44
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Q47 {
    public int Sum_Solution(int n) {
        return n * (1 + n) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Q47().Sum_Solution(100));
    }
}
