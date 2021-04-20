package com.poi.data.structure.and.algorithm.atguigu.sort;

/**
 * @author poi 2021/4/19 19:58
 * @version 1.0
 * 2021/4/19 19:58
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class BucketSortTest {

    public void bucketSortTest() {
        double[] array = new double[] {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
        System.out.println("排序前： " + Arrays.toString(array));
        array = bucketSort(array);
        System.out.println("排序后： " + Arrays.toString(array));
    }

    /**
     * 第 1 步，求数列最大最小值，运算量为 n。
     *
     * 第 2 步，创建空桶，运算量为 n。
     *
     * 第 3 步，把原始数列的元素分配到各个桶，运算量为 n。
     *
     * 第 4 步，把每个桶内部做排序，在元素分布相对均匀的情况下（即一个桶只有一个元素），所有桶的运算量之和为 n。
     *
     * 第 5 步，输出排序数列，运算量为 n。
     *
     * 总上所述，桶排序的总体时间复杂度为 O(n+n+n+n+n)=O(n)
     *
     * 空间复杂度同样是 O(n)。
     * @param array
     * @return
     */

    private double[] bucketSort(double[] array) {
        //获得总差值
        double min = array[0];
        double max = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i]<min) {
                min = array[i];
            }
            if(array[i] > max) {
                max = array[i];
            }
        }
        double d = max - min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for(int i=0; i<bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }
        //往桶里面装元素
        for(int i=0; i<array.length; i++) {
            //获得桶下标
            int bucketIndex = (int)((array[i]-min)/d * (bucketNum-1));// 偏移量:总差值 = 桶下标:(总桶数-1)
            bucketList.get(bucketIndex).add(array[i]);
        }
        for(int i=0; i<bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));//桶内部排序，JDK的归并或Timsort，时间复杂度O(nlogn)
        }
        //创建输出数组（返回数组）
        double[] sortArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList) {
            for(double element : list) {
                sortArray[index++] = element;
            }
        }
        return sortArray;
    }

}
