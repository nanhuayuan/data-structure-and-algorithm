package com.poi.data.structure.and.algorithm.atguigu.DataStructures.linkedlist;

import java.util.Stack;

/**
 * @author poi 2021/2/28 16:05
 * @version 1.0
 * 2021/2/28 16:05
 */
//演示栈Stack的基本使用
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        // 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        // 出栈
        // smith, tom , jack
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }
    }

}
