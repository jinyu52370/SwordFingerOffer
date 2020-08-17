package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 16:23
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class Q34 {
    public int FirstNotRepeatingChar(String str) {
        //z - A = 122 - 65 = 57
        int[] words = new int[58];
        for (int i = 0; i < str.length(); i++) {
            words[((int) str.charAt(i)) - 'A'] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (words[((int) str.charAt(i)) - 'A'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q34().FirstNotRepeatingChar("aabbccdde"));
    }
}
