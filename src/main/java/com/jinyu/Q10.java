package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 22:21
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Q10 {
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int f1 = 1, f2 = 2, temp = 0;
        for (int i = 3; i <= target; i++) {
            temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
