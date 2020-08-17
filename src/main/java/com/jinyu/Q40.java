package com.jinyu;

import java.util.HashMap;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 20:17
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * <p>
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class Q40 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }
        Object[] mapKeyArray = map.keySet().toArray();
        num1[0] = (int) mapKeyArray[0];
        num2[0] = (int) mapKeyArray[1];
    }

    public static void main(String[] args) {
        new Q40().FindNumsAppearOnce(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 6}, new int[1], new int[1]);
    }
}
