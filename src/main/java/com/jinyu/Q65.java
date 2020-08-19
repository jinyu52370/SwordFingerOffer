package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 17:13
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * <p>
 * 例如：
 * a   b   c   e
 * s   f   c   s
 * a   d   e   e
 * ​
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Q65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] verify = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                if (matrix[index] != str[0]) {
                    continue;
                }
                if (dfs(0, i, j, rows, cols, matrix, str, verify)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(int start, int i, int j, int rows, int cols, char[] matrix, char[] str, boolean[] verify) {
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || verify[index] || matrix[index] != str[start]) return false;
        if (start == str.length - 1) return true;
        verify[index] = true;
        if (dfs(start + 1, i + 1, j, rows, cols, matrix, str, verify)) return true;
        if (dfs(start + 1, i, j + 1, rows, cols, matrix, str, verify)) return true;
        if (dfs(start + 1, i - 1, j, rows, cols, matrix, str, verify)) return true;
        if (dfs(start + 1, i, j - 1, rows, cols, matrix, str, verify)) return true;
        verify[index] = false;
        return false;
    }


}
