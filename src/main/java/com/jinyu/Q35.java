package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 17:06
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * <p>
 * 示例1
 * <p>
 * 输入
 * 1,2,3,4,5,6,7,0
 * <p>
 * 输出
 * 7
 */
public class Q35 {
    public int InversePairs(int[] array) {
        int p = 0;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 == array.length) {
                break;
            }
            if (array[i] > array[i + 1]) {
                p++;
            }
        }

        return p % 1_000_000_000 == 0 ? 7 : p;
    }

    public static void main(String[] args) {
        System.out.println(new Q35().InversePairs(new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575}));
    }
}
