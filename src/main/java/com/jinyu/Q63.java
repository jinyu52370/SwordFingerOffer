package com.jinyu;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 15:56
 * <p>
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Q63 {
    private ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);

        int i = list.size() - 2;
        while (i >= 0 && list.get(i) > num) {
            list.add(i, num);
            list.remove(i + 2);
            i--;
        }
    }

    public Double GetMedian() {
        int size = list.size();
        if (size == 1) {
            return Double.valueOf(list.get(0));
        }

        return size % 2 == 0 ? (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0
                : Double.valueOf(list.get(size / 2));
    }

    public static void main(String[] args) {
        Q63 q63 = new Q63();
        int[] ints = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i : ints) {
            q63.Insert(i);
            System.out.println(q63.GetMedian());
        }
    }
}
