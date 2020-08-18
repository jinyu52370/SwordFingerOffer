package com.jinyu;

import java.util.Arrays;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/18 13:55
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * <p>
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class Q51 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        Arrays.fill(B, 1);    // 这步也很关键 使得left[1]可以直接用公式
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i - 1] * A[i - 1];   // left[i]用B[i]代替
        }
        int tempRight = 1;
        for (int i = B.length - 2; i >= 0; i--) {
            tempRight *= A[i + 1];
            B[i] *= tempRight;
        }
        return B;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q51().multiply(new int[]{1, 2, 3, 4, 5})));
    }
}
