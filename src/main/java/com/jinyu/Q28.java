package com.jinyu;

import java.util.HashMap;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 20:53
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Q28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : array) {
            map.put(item, map.containsKey(item) ? map.get(item) + 1 : 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > array.length / 2) {
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Q28().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
