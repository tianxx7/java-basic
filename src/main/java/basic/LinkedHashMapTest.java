package basic;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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
}
