package com.jinyu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 16:10
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Q27 {
    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return result;
        }
        /*
         * \\n：表示匹配第n个括号内匹配到的内容
         * ?=：前瞻：exp1(?=exp2) 查找exp2前面的exp1
         *
         * 总体表示：贪婪匹配所有前面出现过的字符，然后用api替换其为空串
         */
        char[] chars = str.replaceAll("(.)(?=.*\\1)", "").toCharArray();
        Arrays.sort(chars);
        str = new String(chars);

        recursion(str, 0);
        return result;
    }

    public void recursion(String str, int index) {
        if (index == str.length()) {
            result.add(str);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            StringBuilder builder = new StringBuilder(str);
            char tmp = builder.charAt(index);
            builder.setCharAt(index, builder.charAt(i));
            builder.setCharAt(i, tmp);
            str = builder.toString();
            recursion(str, index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q27().Permutation("abcaad"));
    }
}
