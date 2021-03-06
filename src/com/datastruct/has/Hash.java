package com.datastruct.has;

/**
 * 引出哈希的概念
 * 用空间换时间
 *
 *  键 变为 索引 的 哈希函数
 *  不一定 每个键对应唯一的索引   这就是哈希冲突
 *   哈希是 空间和 时间的平衡
 *   假设有无限的空间所有 时间辅助度是 1
 *    假设只有1的空间， 每个都会产生冲突，时间就是 n
 *   但是
 *
 *    设计哈希函数
 *   大整数 比如 身份证号 设计哈希函数
 *   取模 比如 取后面的4位 哈希冲突概率大
 *   取后面的6位  取模。取素数 哈希冲突概率小
 *
 *  字符串的设计  字符串改成大整数
 *    把字符串看成是  按位合成的 166= 1*10的2次方+6*10的1次方+6*10的0次方
 *    B可以是26（26个字母）也可以是其他（字母+符号）
 *    hash(code)= (c*B的3次方+o*B的2次方+d*B的1次方+e*B的0次方)%M
 *    变形
 *    hash(code)= (（(c*B）+o）*B+d+d)*B+e)%M   避免因位如 99次方重复计算多次98次方
 *    M是 模 取素数
 *
 *
 */
public class Hash {

    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1416926;
        System.out.println(((Double)c).hashCode());

        String d = "immoc";
        System.out.println(d.hashCode());
    }
}
