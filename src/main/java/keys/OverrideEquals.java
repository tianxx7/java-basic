package keys;

import java.util.Objects;

/*
* 重写equals和hashCode方法
* 重点是hashCode方法
* */
public class OverrideEquals {
    public String name;
    public int age;
    public String pwd;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof OverrideEquals)) {
            return false;
        }
        OverrideEquals user = (OverrideEquals) obj;
        return user.name.equals(name) &&
                user.age ==age&&
                user.pwd.equals(pwd);
    }

    /*
    * 最简单优雅的方式
    * */
    @Override
    public int hashCode() {
        return Objects.hash(name,age,pwd);
    }

    /*
    * 基于17和31散列码思想的实现
    * */
  /*  @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + name.hashCode();
        result = 31*result + age;
        result = 31*result + pwd.hashCode();
        return result;
    }*/

}
