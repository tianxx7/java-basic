package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void testHashMapCapacity(){
        Map<String,String> map = new HashMap<>();//没有put时 初始size是0
        map.put("name","田新兴");
        System.out.println(map);
    }
}
