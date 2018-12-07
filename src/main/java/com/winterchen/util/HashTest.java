package com.winterchen.util;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HashTest {
    /**
    * 待添加入Hash环的服务器列表
    */

/*

//    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
//                             "192.168.0.3:111", "192.168.0.4:111"};
    private static String[] ips = {"192.168.1.100", "192.168.1.99", "192.168.1.98",
            "192.168.1.97", "192.168.1.96"};
    private static String[] tables ={"data_1","data_2","data_3","data_4","data_5"};
    */
/**
    * * key表示服务器的hash值，value表示服务器的名称
    *//*

    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    */
/**
    * * 程序初始化，将所有的服务器放入sortedMap中
    */
    /*

    static
    {
//               for (int i = 0; i < servers.length; i++)
//               {
//                   int hash = getHash(servers[i]);
//                   System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
//                   sortedMap.put(hash, servers[i]);//哈希值和名称
//               }
//               System.out.println();

               for(int i=0;i<tables.length;i++)//TODO:YAJ
               {
                   int hash = getHash(ips[i]);
                   System.out.println(ips[i] + "加入集合中，其hash值为：" + hash);
                   sortedMap.put(hash, tables[i]);
               }
    }
   */
/**
         使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
   **//*

   private static int getHash(String str)
   {
          final int p = 16777619;
          int j;
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
       */
/**
        * 得到应当路由到的结点
        * **//*

       private static String getTable(String node)//TODO:可以看一下人家是怎么写的，经过了哪些步骤，就把结点对应的服务器找到了？
       {
           // 得到带路由的结点的Hash值
           int hash = getHash(node);
           // 得到大于该Hash值的所有Map
           SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
           // 第一个Key就是顺时针过去离node最近的那个结点
           Integer i = subMap.firstKey();
           // 返回对应的服务器名称
           return subMap.get(i);
       }
       public static void main(String[] args)
       {
           String[] nodes = {"192.168.1.100", "192.168.1.99", "192.168.1.98",
                   "192.168.1.97", "192.168.1.96"};
//           String[] nodes = {"192.168.1.100", "192.168.1.99","192.168.1.98", "192.168.1.97", "192.168.1.96", "192.168.1.95"};
           for (int i = 0; i < nodes.length; i++)
               System.out.println("[" + nodes[i] + "]的hash值为" +
                       getHash(nodes[i]) + ", 被路由到结点[" + getTable(nodes[i]) + "]");
       }
}

*/




    /**
           * 待添加入Hash环的服务器列表
            */
      private static String[] servers = { "192.168.0.0:111","192.168.0.1:111", "192.168.0.2:111","192.168.0.3:111","192.168.0.4:111", "192.168.0.5:111"};

             /**
      * 真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
     */
       private static List<String> realNodes = new LinkedList<String>();
  /**
    * 虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
    */
        private static SortedMap<Integer, String> virtualNodes =
                  new TreeMap<Integer, String>();

         /**
      * 虚拟节点的数目，这里写死，为了演示需要，一个真实结点对应5个虚拟节点
    */
          private static final int VIRTUAL_NODES = 50;

       /*static
    {
            // 先把原始的服务器添加到真实结点列表中
             for (int i = 0; i < servers.length; i++)
                     realNodes.add(servers[i]);

            // 再添加虚拟节点，遍历LinkedList使用foreach循环效率会比较高
             for (String str : realNodes)
                 {
                     for (int i = 0; i < VIRTUAL_NODES; i++)
                            {
                                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                                int hash = getHash(virtualNodeName);
                                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                                virtualNodes.put(hash, virtualNodeName);
                            }
                 }
             System.out.println();
       }*/

       /**
 * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
 */
       private static int getHash(String str){

          final int p = 16777619;
          int pp;
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
     * 得到应当路由到的结点
     */
     private static String getServer(String node){

        // 得到带路由的结点的Hash值
        int hash = getHash(node);
        // 得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap =
                        virtualNodes.tailMap(hash);
        Integer i=null;
        String virtualNode = null;
        if(subMap==null||subMap.size()==0){
                i=virtualNodes.firstKey();
                virtualNode=virtualNodes.get(i);
            }else{
                 i = subMap.firstKey();
                 virtualNode= subMap.get(i);
            }
      // 第一个Key就是顺时针过去离node最近的那个结点

      // 返回对应的虚拟节点名称，这里字符串稍微截取一下
      return virtualNode.substring(0, virtualNode.indexOf("&&"));
  }

   public static void main(String[] args){
      /* HashMap<String,Integer> map=new HashMap<String, Integer>();
       List<String> id=new ArrayList<String>();
       for(int i=0;i<6;i++){
                 id.add(UUID.randomUUID().toString().replace("-", ""));
                 //id.add("adasfdsafdsgfdsagdsafdsafdsaf"+i);
             }
         for (int i = 0; i < id.size(); i++){
                 String aString=getServer(id.get(i));
                 Integer aInteger=map.get(aString);
              if(aInteger==null)
              {
                  map.put(aString,1);
              }else{
                  map.put(aString, aInteger+1);
              }
              }
                 Set<String> set= map.keySet();
                 for(String a:set){
                         System.out.println("节点【"+a+"】分配到元素个数为==>"+map.get(a));
                     }*/

//       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//       Date d = new Date();
//       System.out.println("当前时间："+ new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(d));
//       System.out.println(sdf.parse("2018-11-27 10:14:10"));


       String time = "2015-10-08 17:00:00";
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date date_util = null; //转换为util.date
       try {
           date_util = sdf.parse(time);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       java.sql.Date date_sql = new java.sql.Date(date_util.getTime());//转换为sql.date
       System.out.println(date_util);
       System.out.println(date_sql);
       String date = sdf.format(date_sql);
       System.out.println(date);
       date = sdf.format(date_util);
       System.out.println(date);
     }
}
