package com.jinyu;

import java.util.ArrayList;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 20:44
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Q41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
        int count;

        for (int i = 1; i <= sum / 2 + 1; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            count = i;
            for (int j = i + 1; j <= sum / 2 + 1; j++) {
                list.add(j);
                count += j;
                if (count == sum) {
                    allList.add(list);
                    break;
                }
            }
        }
        return allList;
    }

    public static void main(String[] args) {
        System.out.println(new Q41().FindContinuousSequence(3));
    }
}
