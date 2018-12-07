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
    public static String[] suffix ={"1","2","3","4","5"};
    /**
     * * key表示表的hash值，value表示数据库表的名称
     */
    private static SortedMap<String, String> sortedMap = new TreeMap<>();
//    private static Map<String,String>

    /**
     * * 程序初始化，将所有的表放入sortedMap中
     */
    static
    {
        for(int i=0;i<ips.length;i++)
        {
            sortedMap.put(ips[i], suffix[i]);
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
    public static String getSuffix(String node)
    {
        return sortedMap.get(node);
    }

    public static void main (String[] aa){
        System.out.println(getSuffix("192.168.9.100"));
    }
}


