package com.jinyu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 16:29
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy.
 */
public class Q2 {
    public static String replaceSpace(StringBuffer str) {
        StringBuilder builder = new StringBuilder();

        for (char c : str.toString().toCharArray()) {
            builder.append(c == 32 ? "%20" : String.valueOf(c));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));

    }
}
