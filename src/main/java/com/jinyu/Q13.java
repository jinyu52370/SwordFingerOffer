package com.jinyu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 10:42
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class Q13 {
    public void reOrderArray(int[] array) {
        int[] leftOdd = new int[array.length];
        int[] rightEven = new int[array.length];

        int leftIndex = 0, rightIndex = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                rightEven[rightIndex] = i;
                rightIndex++;
            } else {
                leftOdd[leftIndex] = i;
                leftIndex++;
            }
        }

        System.arraycopy(leftOdd, 0, array, 0, leftIndex);
        System.arraycopy(rightEven, 0, array, leftIndex, rightIndex);
    }

    public static void main(String[] args) {
        new Q13().reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}
