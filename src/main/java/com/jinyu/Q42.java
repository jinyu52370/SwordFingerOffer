package com.jinyu;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 21:04
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class Q42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0) {
            return list;
        }

        int left = 0, right = array.length - 1;
        //最大加次大小于sum，则不可能有两个数的和为sum
        if (array[right] + array[right - 1] < sum) {
            return list;
        }

        while (left <= right) {
            if (array[left] + array[right] == sum) {
                if (list.isEmpty()) {
                    list.add(array[left]);
                    list.add(array[right]);
                }
                if (array[left] * array[right] < list.get(0) * list.get(1)) {
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                }
                left++;
                right--;
                continue;
            }
            if (array[left] + array[right] > sum) {
                right--;
            }
            if (array[left] + array[right] < sum) {
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Q42().FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 16}, 17));
    }
}
