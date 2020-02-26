package TextClass;

/**
 * @author WangYao
 * @date 2019/11/25
 * @function
 */
public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名 " + name + ", 年龄" + age;
    }
}
