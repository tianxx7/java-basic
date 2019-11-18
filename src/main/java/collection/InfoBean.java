package collection;

public class InfoBean implements Cloneable {
    private String name;

    private int age;

    public InfoBean() {
    }

    public InfoBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    *
    * */
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    public InfoBean clone(){
        try{
            return (InfoBean)super.clone();
        } catch (CloneNotSupportedException e) {
           return null;
        }
    }
}
