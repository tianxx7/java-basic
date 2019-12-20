package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTest {
    @Test
    public void testHashMapCapacity(){

        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("2",null);
        treeMap.put("3",null);
        treeMap.put("1",null);
        treeMap.forEach( (k,v)->{System.out.println(k+" "+v);});
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null,null);
    }
}
