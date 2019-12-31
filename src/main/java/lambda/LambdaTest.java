package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * lambda 测试
 中间操作
     筛选与切片
         filter(Predicate p) 接收Lambda, 从流中排除某些元素
         distinct() 筛选,通过流所生成元素的HashCode和equals去除重复元素
         limit(long maxSize)  截断流,使元素不超过给定数量
         skip(long n)跳过元素,返回一个扔掉了前n个元素的流,若流中元素不足n个,则返回一个空流,与limit(n)互补
     映射
        map
        mapToDouble
        mapToInt
        mapToLong
        flatMap
 * */
public class LambdaTest {
    /*
    * 创建Stream
    * */
    @Test
    public void createStream(){
        //1.通过Collection 系列集合提供的stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3.通过Stream类中的静态方法of()
        Stream<String> stringStream = Stream.of("a", "b", "c", "d");

        //4.创建无限流
        //迭代  从0开始 无限生成偶数
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        //iterate.forEach(System.out::println);
        iterate.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random())
                .limit(10)
                .forEach(System.out::println);
    }
}
