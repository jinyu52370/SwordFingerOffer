package com.jinyu;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 21:13
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Q19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        return printMatrix(matrix, new ArrayList<>());
    }

    public ArrayList<Integer> printMatrix(int[][] matrix, ArrayList<Integer> list) {
        if (matrix.length == 0) {
            return list;
        }
        //打印第一行：→
        int lineLen = matrix.length;
        int rowLen = matrix[0].length;
        for (int i = 0; i < rowLen; i++) {
            list.add(matrix[0][i]);
        }
        //去除第一行，拷贝到新数组
        if (lineLen - 1 == 0) {
            return list;
        }
        int[][] temp1 = new int[lineLen - 1][rowLen];
        for (int i = 1, j = 0; i < lineLen; i++, j++) {
            System.arraycopy(matrix[i], 0, temp1[j], 0, rowLen);
        }

        //打印最后一列：↓
        lineLen = temp1.length;
        for (int i = 0; i < lineLen; i++) {
            list.add(temp1[i][rowLen - 1]);
        }
        //去除最后一列，拷贝到新数组
        if (rowLen - 1 == 0) {
            return list;
        }
        int[][] temp2 = new int[lineLen][rowLen - 1];
        for (int i = 0; i < lineLen; i++) {
            System.arraycopy(temp1[i], 0, temp2[i], 0, rowLen - 1);
        }

        //打印最后一行：←
        rowLen = temp2[0].length;
        for (int i = rowLen - 1; i >= 0; i--) {
            list.add(temp2[lineLen - 1][i]);
        }
        //去除最后一行，拷贝到新数组
        if (lineLen - 1 == 0) {
            return list;
        }
        int[][] temp3 = new int[lineLen - 1][rowLen];
        for (int i = 0; i < lineLen - 1; i++) {
            System.arraycopy(temp2[i], 0, temp3[i], 0, rowLen);
        }

        //打印第一列：↑
        lineLen = temp3.length;
        for (int i = lineLen - 1; i >= 0; i--) {
            list.add(temp3[i][0]);
        }
        //去除第一列，拷贝到新数组
        if (rowLen - 1 == 0) {
            return list;
        }
        int[][] temp4 = new int[lineLen][rowLen - 1];
        for (int i = 0; i < lineLen; i++) {
            System.arraycopy(temp3[i], 1, temp4[i], 0, rowLen - 1);
        }
        printMatrix(temp4, list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Q19().printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
    }
}
