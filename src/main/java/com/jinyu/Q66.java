package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 17:13
 * <p>
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * <p>
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * <p>
 * 请问该机器人能够达到多少个格子？
 */
public class Q66 {
    private boolean[][] visited;//保证了格子不会重复计数
    private int k;
    private int rows;
    private int cols;

    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows][cols];//默认是false
        this.k = threshold;
        this.rows = rows;
        this.cols = cols;
        return dfs(0, 0, 0, 0);//从00开始，位数和为00
    }

    private int dfs(int x, int y, int xSum, int ySum) {
        //先做边界判断,如果超出边界则这一步可抵达的格子数为0
        if (x > rows - 1 || y > cols - 1) {
            return 0;
        }
        //判断当前格子是否满足要求
        if (xSum + ySum > k || visited[x][y]) {
            return 0;
        }
        //如果当前格子满足要求，1+往下走或者往右走可以到达的格子数
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, (x + 1) % 10 == 0 ? xSum - 8 : xSum + 1, ySum)
                + dfs(x, y + 1, xSum, (y + 1) % 10 == 0 ? ySum - 8 : ySum + 1);
    }
}
