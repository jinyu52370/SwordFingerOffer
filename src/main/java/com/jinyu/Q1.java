package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 15:50
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Q1 {
    public static boolean Find(int target, int [][] array) {
        if (array == null || (array.length == 0) || (array[0].length == 0)) {
            return false;
        }
        int rowLen = array[0].length;
        for (int[] lineItem : array) {
            if (target > lineItem[rowLen - 1]) {
                continue;
            }
            if (target == lineItem[0] || (target == lineItem[rowLen - 1])) {
                return true;
            }
            for (int j = 1; j < rowLen - 1; j++) {
                if (target == lineItem[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[3][5];
        int num = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = num;
                num++;
            }
        }

        System.out.println(Find(15, array));
    }
}
