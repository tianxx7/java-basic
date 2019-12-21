package basic;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.*;

public class LinkedHashMapTest {
    @Test
    public void testLinkedHashMap(){
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("b","2");
        linkedHashMap.put("a","1");
        linkedHashMap.put("c","3");
        System.out.println(JSON.toJSONString(linkedHashMap));

        LinkedHashMap<String,String> linkedHashMap2 = new LinkedHashMap<>();
        linkedHashMap2.put("b","2");
        linkedHashMap2.put("a","1");
        linkedHashMap2.put("c","3");
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        System.out.println(gson.toJson(linkedHashMap2));

        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("1",null);
        treeMap.put("3",null);
        treeMap.put("2",null);
        treeMap.forEach((key,value) ->{
            System.out.println(key+":" + value);
        });


    }

    //LRU
    public class LRUCache<K,V> extends LinkedHashMap<K,V>{
        private int maxEntries;
        public LRUCache(int maxEntries){
            this.maxEntries = maxEntries;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size()>maxEntries;
        }
    }

    @Test
    public void hashTableTest() {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("name","yan");
        hashtable.put("city","zhuhai");

        System.out.println(hashtable.contains("name"));//false  比较的是value   value.equals()
        System.out.println(hashtable.contains("yan"));//true
        System.out.println(hashtable.containsKey("name"));//true
        System.out.println(hashtable.containsValue("yan"));//true
    }
}
