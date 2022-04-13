package com.poi.data.structure.and.algorithm.atguigu.Algorithm.n4kmp;

import java.util.Arrays;

/**
 * @author poi 2021/4/26 0:14
 * @version 1.0
 * 2021/4/26 0:14
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";

        int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15了*/


        String str2 = "ABCDABD";
        int[] next = getNext(str2);


    }

    //写出我们的kmp搜索算法
    /**
     *
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表, 是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {

        //遍历
        for(int i = 0, j = 0; i < str1.length(); i++) {

            //需要处理 str1.charAt(i) ！= str2.charAt(j), 去调整j的大小
            //KMP算法核心点, 可以验证...
            while( j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if(j == str2.length()) {//找到了 // j = 3 i
                return i - j + 1;
            }
        }
        return  -1;
    }

    //获取到一个字符串(子串) 的部分匹配值表
    public static  int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        for(int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static int[] getNext(String dest) {
        int pLen = dest.length();
        int[] next = new int[pLen];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1)
        {
            //p[k]表示前缀，p[j]表示后缀
            //k值为-1意味着前面没有匹配的,当前位置(j)的值可以确定了(就是0)
            //这句话意味着可以确定next数组当前位置(j)的值
            if (k == -1 || dest.charAt(j) == dest.charAt(k)) {
                ++k;
                ++j;
                next[j] = k;
            }
            //如果当前不匹配,继续往前找
            //为什么能往前找,因为这个是固定的字符串,开头都是一定的例如开头AB,就是开头AB,只用找不断往前找已经匹配过了的
            //为什么不一个往前找?
            else {
                k = next[k];
            }
        }
        return next;
    }



    //优化过后的next 数组求法
    //不该出现p[j] = p[ next[j] ]。
    // 为什么呢？理由是：当p[j] != s[i] 时，下次匹配必然是p[ next [j]] 跟s[i]匹配，
    // 如果p[j] = p[ next[j] ]，必然导致后一步匹配失败（因为p[j]已经跟s[i]失配，
    // 然后你还用跟p[j]等同的值p[next[j]]去跟s[i]匹配，很显然，必然失配）

    public static void GetNextval(String dest)
    {
        int pLen = dest.length();
        int[] next = new int[pLen];
        int k = -1;
        int j = 0;
        while (j < pLen - 1)
        {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || dest.charAt(j) == dest.charAt(k))
            {
                ++j;
                ++k;
                //较之前next数组求法，改动在下面4行
                if (dest.charAt(j) == dest.charAt(k))
                    next[j] = k;   //之前只有这一行
                else
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
            }
            else
            {
                k = next[k];
            }
        }
    }


}

