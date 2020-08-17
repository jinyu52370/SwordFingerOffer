package com.jinyu;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 21:15
 * <p>
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Q30 {
    private final ArrayList<Integer> list = new ArrayList<>();

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        for (int i = 0; i < array.length; i++) {
            recursion(i, array.length, array);
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public void recursion(int i, int len, int[] array) {
        if (i == len) {
            return;
        }
        int sum = 0;
        for (int j = i; j < len; j++) {
            sum += array[j];
        }
        list.add(sum);
        recursion(i, len - 1, array);
    }

    public static void main(String[] args) {
        System.out.println(new Q30().FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));
    }
}
