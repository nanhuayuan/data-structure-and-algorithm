package com.poi.data.structure.and.algorithm.atguigu.DataStructures.recursion;

/**
 * @author poi 2021/2/28 22:41
 * @version 1.0
 * 2021/2/28 22:41
 */
public class RecursionTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //通过打印问题，回顾递归调用机制
        test(4);

        //int res = factorial(3);
        //System.out.println("res=" + res);
    }
    //打印问题. 
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } //else {
        System.out.println("n=" + n);
        // }
    }
    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n; // 1 * 2 * 3
        }
    }


}
