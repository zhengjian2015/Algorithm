package com.datastruct;

//第一版本的并查集
//存0-9十个编号，可能分别代码10个人，他们对应的集合id
public class UnionFind1 implements UF {

    private int[] id;    //对应的集合编号

    //每个元素对应的集合编号都不一样，也就是说都不属于同一集合
    //后面可以同过并操作1个个 分组
    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++)
            id[i] = i;
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查找元素p对应的集合编号
    private int find(int p) {
        if (p < 0 || p > id.length) {
            throw new IllegalArgumentException("p is out of bond");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    /**并的操作，假设数组分为两个集合，合并两个原本不同的集合
      union后就都属于同1集合了
     * 时间复杂度太高了，O(n)后面优化的思路是 树
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}
