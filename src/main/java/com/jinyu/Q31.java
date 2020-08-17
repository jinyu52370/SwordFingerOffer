package com.jinyu;


/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/16 21:49
 * <p>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Q31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int counts = 0;
        for (int i = 1; i <= n; i = i * 10) {
            int a = n / i;
            int b = n % i;
            //a%10表示上一位是否为1，为0?后一位为几就加几:0
            counts += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);

        }
        return counts;
    }

    public static void main(String[] args) {

    }
}
