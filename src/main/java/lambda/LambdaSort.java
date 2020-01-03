package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaSort {
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
    * 自热排序
    * */
    @Test
    public void test1(){
        List<String> strings = Arrays.asList("ccc","aaa","ddd","bbb","eee","fff");
        strings.stream()
                .sorted()
                .forEach(System.out::println);

        employees.stream()
                .sorted((e1,e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return e1.getAge() - e2.getAge();
                    }
                }).forEach(System.out::println);
    }
}
