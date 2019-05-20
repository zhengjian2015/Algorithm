package com.datastruct;

/**
 * 并查集 解决连接问题 如社交网络 两个人是否通过好友认识等
 *
 *  把1行数 分成两个集合 id为0和id为1  判断两个数是否相连，就判断是否属于同1集合
 *
 *
 */
public interface UF {

    int getSize();
    //id为p 和 id为q 这两个元素是否相连
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
