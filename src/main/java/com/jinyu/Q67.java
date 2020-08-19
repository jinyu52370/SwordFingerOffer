package com.jinyu;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/19 17:13
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？
 * <p>
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Q67 {
    public int cutRope(int target) {
        int max = 1;
        if (target <= 3 && target > 0) {
            return target - 1;
        }
        while (target > 4) {
            target -= 3;
            max *= 3;
        }
        return max * target;
    }


    public static void main(String[] args) {
        System.out.println(new Q67().cutRope(16));
    }
}
