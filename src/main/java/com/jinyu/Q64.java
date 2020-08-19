package com.jinyu;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 17:13
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * <p>
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 窗口大于数组长度的时候，返回空
 */
public class Q64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size == 0) {
            return list;
        }
        if (size == 1) {
            for (int i : num) {
                list.add(i);
            }
            return list;
        }

        int left = 0, right = size - 1;
        while (right < num.length) {
            int max = num[left];
            for (int i = left + 1; i <= right; i++) {
                max = Math.max(max, num[i]);
            }
            list.add(max);
            left++;
            right++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Q64().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }
}
