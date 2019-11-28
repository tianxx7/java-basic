package generic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/*
* 泛型在运行期间无法获得类型信息
* Gson是如何解析泛型类型Bean结构
* */
public class GsonTest {
    @Test
    public void arrayTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        String gStr = new Gson().toJson(list,type);
        ArrayList<String> gList = new Gson().fromJson(gStr, type);
        /*
        * 可以看到TypeToken的使用非常简单,只用将需要获取类型的泛型类作为TypeToken的泛型参数构造参数构造一个匿名子类就可以通过getType
        * 方法获取到我们使用的泛型类的泛型参数类型
        * */
    }

    @Test
    public void gsonTest(){
        Type mySuperclass = new ArrayList<String>() {
        }.getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
        System.out.println(type);//class java.lang.String
        /*
        * 获取泛型参数类型的实质就是通过Class类的getGenericSuperClass方法返回一个ParameterizedType
        * 对象(对于Object,接口和原始类型返回null,对于数组class返回Object.class),ParameterizedType表示带有泛型
        * 参数类型的Java类型,Java1.5引入泛型后Java中所有的Class都实现了Type接口
        * ParameterizedType继承了Type接口,所有包含泛型的Class类都会自动实现这个接口
        * */
    }

    @Test
    public void reflectTest() throws NoSuchFieldException, NoSuchMethodException {
        ParameterizedType type = (ParameterizedType) Bar.class.getGenericSuperclass();
        System.out.println(type.getActualTypeArguments()[0]);//class java.lang.String

        ParameterizedType fieldType = (ParameterizedType) Foo.class.getField("children").getGenericType();
        System.out.println(fieldType.getActualTypeArguments());//[Ljava.lang.reflect.Type;@15327b79
        System.out.println(fieldType.getActualTypeArguments()[0]);//class generic.Bar

        ParameterizedType getName = (ParameterizedType) Foo.class.getMethod("foo", List.class).getGenericParameterTypes()[0];
        System.out.println(getName.getActualTypeArguments()[0]);//class java.lang.String

        System.out.println(Foo.class.getTypeParameters()[0].getBounds()[0]);//interface java.lang.CharSequence
    }
}

class Foo<T extends CharSequence>{
    public List<Bar> children = new ArrayList<Bar>();
    public List<StringBuilder> foo(List<String> foo) {
        return null;
    }

    public void bar(List<? extends String> param){}
}

class Bar extends Foo<String>{

}
