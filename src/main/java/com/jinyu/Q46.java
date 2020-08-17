package com.jinyu;

import com.jinyu.node.ListNode;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/17 22:43
 * <p>
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * <p>
 * 如果没有小朋友，请返回-1
 */
public class Q46 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }

        //循环链表
        ListNode[] listNodes = new ListNode[n];
        for (int i = 0; i < n; i++) {
            listNodes[i] = new ListNode(i);
        }
        for (int i = 0; i < n - 1; i++) {
            listNodes[i].next = listNodes[i + 1];
        }
        listNodes[n - 1].next = listNodes[0];
        //头指针
        ListNode head = listNodes[0];
        ListNode pre = listNodes[n - 1];
        //报数
        while (head != pre) {
            int count = 0;
            while (count != m - 1) {
                head = head.next;
                pre = pre.next;
                count++;
            }
            //唱歌的小朋友出圈
            pre.next = head.next;
            head = head.next;
        }

        return head.val;
    }

    public int LastRemaining_Solution1(int n, int m) {
        int s = 0;
        if(m == 0){
            return -1;
        }
        for(int i = 2; i <= n; i++){
            s = (s + m) % i;

        }
        return s;
    }

    public static void main(String[] args) {
        new Q46().LastRemaining_Solution(5, 3);
    }
}
