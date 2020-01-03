package lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
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
        map:
        接收一个lambda,将元素转换成其他形式或提取信息,接收一个函数作为参数,该函数会被应用到每个元素上
        并将其映射成一个新的元素,

        mapToDouble
        mapToInt
        mapToLong
        flatMap
        接收一个函数作为参数,将流中的每个值都转换成另一个流,然后把所有流连接成一个流

    排序
        sorted()-自然排序
        sorted(Comparator com) - 定制排序



    终止操作
        查找与匹配:
            allMatch-检查是否匹配所有元素 匹配所有元素为true , 反之为false
            anyMatch-检查是否至少匹配一个元素 只要有一个匹配就是true
            noneMatch-检查是否没有匹配所有元素,有匹配的元素就是false,
            findFirst-返回第一个元素
            findAny-返回当前流中的任意元素
            count-返回流中元素的总个数
            max-返回流中最大值
            min-返回流中最小值

    规约
       reduce(T identity,BinaryOperator)/reduce(BinaryOperator) - 可以将元素反复结合起来,得到一个值
    收集
       collect-将流转换为其他形式,接收一个collector接口实现,用于给stream中元素做汇总的方法

 * */
public class LambdaTest {
    /*
     * 创建Stream
     * */
    @Test
    public void createStream() {
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
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        //iterate.forEach(System.out::println);
        iterate.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random())
                .limit(10)
                .forEach(System.out::println);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("刘二",25,8888.8),
            new Employee("张三",18,3333.3),
            new Employee("李四",58,4444.4),
            new Employee("王五",26,5555.5),
            new Employee("王五",26,5555.5),
            new Employee("王五",26,5555.5),
            new Employee("赵六",36,6666.6),
            new Employee("前七",12,7777.7));

    /*
     * 中间操作
     * 筛选与切片
     * */
    @Test
    public void test2() {
        //中间操作,惰性求值
        Stream<Employee> employeeStream = employees.stream()
                .filter(item -> item.getAge() > 35);
        //终止操作:一次性执行全部内容,即"惰性求值"
        employeeStream.forEach(System.out::println);
    }


    @Test
    public void test3(){
        employees.stream()
                .filter(item -> item.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
    }


    @Test
    public void test4(){
        employees.stream()
                .filter(item -> {
                    System.out.println("短路");
                    return item.getSalary() > 2000;
                })
                .limit(2).forEach(System.out::println);
        //找到满足条件的2条后,就不在进行迭代了,提高效率
    }

    @Test
    public void test5(){
        employees.stream()
                .filter(item -> item.getSalary() > 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
        //找到满足条件的2条后,就不在进行迭代了,提高效率
    }


    /*
    * 映射
    *
    * map
    * flatmap
    * */
    @Test
    public void test6(){
        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        strings.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
        System.out.println("-----------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("-----------");

        Stream<Stream<Character>> streamStream = strings.stream()
                .map(LambdaTest::filterCharacter);
        streamStream.forEach(sm ->{
            sm.forEach(System.out::println);
        });
    }

    @Test
    public void test7(){
        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        Stream<Character> characterStream = strings.stream()
                .flatMap(LambdaTest::filterCharacter);
        //平流
        characterStream.forEach(System.out::println);
    }


    public static Stream<Character> filterCharacter(String string){
       List<Character> list = new ArrayList<>();
       for (Character ch : string.toCharArray()){
           list.add(ch);
       }
       return list.stream();
    }

    @Test
    public void test8(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //参数  起始值,运算
        Integer sum = integers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test9(){
        //collect 收集方式
        List<String> collect = employees.stream().map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        HashSet<String> collect1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        collect1.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //总数
        Long collect = employees.stream()
                .collect(Collectors.counting());
        System.out.println(collect);
        //平均值
        Double collect1 = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect1);

        //和
        Double collect3 = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect3);
        //最大值
        Optional<Employee> collect4 = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect4.get());

        //最小值
        Optional<Employee> collect5 = employees.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect5.get());
        //统计信息 和 最大 最下 平均
        DoubleSummaryStatistics collect2 = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect2);
    }

    @Test
    public void test11(){
        //分组 按年龄分组
        Map<Integer, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));

        //多级分组 按工资分再按年龄分
        Map<Double, Map<String, List<Employee>>> collect1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.groupingBy(e -> {
                    if (((Employee) e).getAge() < 35) {
                        return "青年";
                    } else {
                        return "中年";
                    }
                })));
        //分片/分区  true/false两个区
        Map<Boolean, List<Employee>> collect2 = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));

    }
}
