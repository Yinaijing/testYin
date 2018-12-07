package com.winterchen.util;


import java.util.SortedMap;
import java.util.TreeMap;

public class Hash {
    private static String node;
    public static String getNode() {
        return node;
    }
    public static void setNode(String node1) {
        node = node1;
    }
    /**
     * 待添加入Hash环的数据表列
     */
    public static String[] ips ={"192.168.9.100","192.168.9.99","192.168.9.98","192.168.9.97","192.168.9.96"};
    public static String[] tables ={"data_1","data_2","data_3","data_4","data_5"};//完整数据的表
//    public static String[] abtables ={"abdata_1","abdata_2","abdata_3","abdata_4","abdata_5"};//异常数据的表
    /**
     * * key表示表的hash值，value表示数据库表的名称
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();
//    private static Map<String,String>

    /**
     * * 程序初始化，将所有的表放入sortedMap中
     */
    static
    {
        for(int i=0;i<ips.length;i++)
        {
            int hash = getHash(ips[i]);
            sortedMap.put(hash, tables[i]);
        }
    }
    /**
     使用FNV1_32_HASH算法计算表的Hash值
     **/
    public static int getHash(String str)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
    /**
     * 得到应当路由到的结点，这里的结点指的是数据记录中的ip
     * **/
    public static String getTable(String node)//TODO:可以看一下人家是怎么写的，经过了哪些步骤，就把结点对应的服务器找到了？
//    public static String getTable()//如果用get，set方法去赋值的话，就不需要传参了
    {
        // 得到带路由的结点的Hash值

//        String node1 = getNode();
//        int hash = getHash(node1);
        int hash = getHash(node);
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 第一个Key就是顺时针过去离node最近的那个结点
        Integer i = subMap.firstKey();
        // 返回对应的服务器名称
        return subMap.get(i);
    }

    /*public static void main(String[] args){

    }*/
}


