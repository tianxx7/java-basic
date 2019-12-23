package hash;

import org.junit.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapTest {

    @Test
    public void enumMapTest(){
        Map<String,String> map = new HashMap<>();
        map.put("name","txx");
        EnumMap enumMap = new EnumMap(map);
        System.out.println();
    }
}
