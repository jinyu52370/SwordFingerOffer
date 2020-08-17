package com.jinyu;

import java.util.Stack;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/8/14 20:24
 * <p>
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Q5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        for (int i = 0; i < 5; i++) {
            q5.push(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(q5.pop());
        }
    }
}
