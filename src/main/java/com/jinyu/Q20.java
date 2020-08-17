package com.jinyu;

import java.util.Stack;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/15 23:37
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Q20 {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (min.empty()) {
            min.push(node);
        } else {
            min.push(node <= min.peek() ? node : min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {

    }
}
