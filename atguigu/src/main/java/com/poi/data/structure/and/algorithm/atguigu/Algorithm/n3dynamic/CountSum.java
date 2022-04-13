package com.poi.data.structure.and.algorithm.atguigu.Algorithm.n3dynamic;

/**
 * @Description: 数组能组合成指定值
 * @Author: songkai
 * @Date: 2021/4/26
 * @Version: 1.0
 */
public class CountSum {

    /**
    *   arr     i  0   1   2   3   4   5   6   7   8   9
    *   3       0   F   F   F   F   F   F   F   F   F   F
    *   34      1   T
    *   4       2   T
    *   12      3   T
    *   5       4   T
    *   2       5   T
    */

    /**
    * @Description: 递归求数组的能否和达成某个数
    * @Author: songkai 
    * @Date: 2021/4/26
    * @Param: * @param null
    * @return: 
    */ 
    public static boolean fixedSumByRec(int[] arr, int i, int s){
        if (s == 0){
            return true;
        } else if (i == 1) {
            return arr[0] == s;
        } else if(arr[i] > s){
            return fixedSumByRec(arr, i - 1, s);
        } else {
            boolean a = fixedSumByRec(arr, i - 1, s- arr[i]);
            boolean b = fixedSumByRec(arr, i - 1, s);
            return a || b;
        }
    }


    public static boolean fixedSumByDp(int[] arr, int i, int s){
        boolean[][] subset = new boolean[arr.length][s + 1];
        for (int j = 0; j < subset.length; j++) {
            subset[0][j] = false;
        }
        for (int j = 0; j < subset[0].length; j++) {
            subset[j][0] = true;
        }
        subset[0][arr[0]] = true;

        for (int j = 1; j < arr.length; j++){
            for (int k = 1; k < s + 1; k++) {
                if (arr[i] > s){
                    subset[i][k] = subset[i - 1][k];
                }else {
                    boolean a = subset[i - 1][s-arr[i]];
                    boolean b = subset[i - 1][s];
                    subset[i][k] = a || b;
                }
            }
        }
        return subset[arr.length - 1][s];
    }


}
