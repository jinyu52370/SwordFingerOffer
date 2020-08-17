package com.jinyu;

import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 20:37
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Q6 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int maxIndex = 1, minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        maxIndex++;

        int[] left = Arrays.copyOfRange(array, 0, maxIndex);
        int[] right = Arrays.copyOfRange(array, maxIndex, array.length);

        int leftLen = left.length, rightLen = right.length;

        right = Arrays.copyOf(right, leftLen + rightLen);
        System.arraycopy(left, 0, right, rightLen, leftLen);

        for (int i = 1; i < rightLen; i++) {
            if (right[i] < right[minIndex]) {
                minIndex = i;
            }
        }
        return right[minIndex];
    }

    public static void main(String[] args) {
        System.out.println(new Q6().minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    }
}
