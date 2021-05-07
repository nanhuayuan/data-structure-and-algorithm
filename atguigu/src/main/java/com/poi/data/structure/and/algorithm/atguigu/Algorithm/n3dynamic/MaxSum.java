package com.poi.data.structure.and.algorithm.atguigu.Algorithm.n3dynamic;

/**
 * @author poi 2021/4/25 23:56
 * @version 1.0
 * 2021/4/25 23:56
 */
public class MaxSum {


     //求数组不相邻的数最大和
    /*动态规划在于选与未选
        退出条件
          只剩一个,那就返回这个
          剩下两个,返回大的
        其他情况 分为选和不断
            选-最大可能就是前两位最大值 + 该位指
            不选-
     */
    //递归求数组最大和-递归方法
    public static int maxSumByRec(int[] arr ,int i){
        if (i == 0){
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int a = maxSumByRec(arr, i - 2)  + arr[i] ;
            int b = maxSumByRec(arr, i - 1) ;
            return Math.max(a, b);
        }
    }

    //非递归
    public static int maxSumBydp(int[] arr){
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int a = opt[i - 2] + arr[i];
            int b = opt[i - 1];
            opt[i] = Math.max(a,b);
        }
        return opt[opt.length - 1];
    }
}
