package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 18:22
 * <p>
 * 统计一个数字在升序数组中出现的次数。
 */
public class Q37 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] == k) {
                        count++;
                        continue;
                    }
                    break;
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q37().GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3}, 3));
    }
}
