package Small.CloneAndInner;

import TextClass.Book;

/**
 * @author WangYao
 * @date 2019/12/13
 * @function
 */
public class CloneDemo {

//    abstract class P{}    //ok

    public Person1 getPerson1(){
        return new Person1();
    }

    public final class Person1 implements Cloneable{
        Integer age;
        String name;
        Book b;

        //非静态内部类不能有静态方法
//        static int a(){
//            return 1;
//        }

        CloneDemo x(){
            return CloneDemo.this;
        }

        /*
         * 深克隆
         * 如果Book为null,可以直接使用Object的克隆
         * 先克隆一个Book,就ok了
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            if(b == null)
                return super.clone();
            Person1 p = new Person1();
            p.age = age;
            p.b = (Book) this.b.clone();
            return p;
        }
    }


    public void Text(){

    }

    public static void main(String[] args) throws Exception {
        /*
         * 局部内部类
         */
//        class Person3{}

        /*
         * 匿名内部类
         */
//        Comparable c = new Comparable() {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        };

        /*
         * 非静态成员内部类的使用(静态不能这么用)
         * (这使得内部类捕获到一个外围类的对象,从而可以在内部类里面使用外围类的方法和属性)
         */
//        CloneDemo c = new CloneDemo();
//        CloneDemo.Person1 p = c.new Person1();
//        System.out.println(p.age);

        /*
         * 静态成员内部类的使用
         * 直接使用类来创建,使得内部类只能使用外围类的静态属性与方法
         */
//        Person1 p = new Person1();
//        Person1 p1 = new CloneDemo.Person1();

        /*
         * 浅克隆(克隆了基本类型及封装类) (包括String)但是不包括StringBuild与StringBuffer  可能是因为final
         */

//        Person1 p1 = new Person1();
//        Person1 p2 = new Person1();

        //直接上=号是引用,实际只有一个对象
//        p2 = p1;
//        p1.age = 5;
//        System.out.println(p2.age);

        //必须重写clone方法使其可见性为public
//        p2 = (CloneDemo.Person1) p1.clone();//这里有异常 java.lang.CloneNotSupportedException
//        p1.name = "p1";
//        p1.age = 4;
//        System.out.println("age: " + p2.age);
//        System.out.println("name: " + p2.name);

        /*
         * 深克隆(使用clone)
         */
//        Person1 p3 = new Person1();
//        Person1 p4 = new Person1();
//
//        p3.b = new Book("你好","1");
//        p4 = (CloneDemo.Person1) p3.clone();
//
//        p3.b.setName("不好");
//        System.out.println(p4.b.getName());

    }
}
//这个算什么类呢?
class Person2{

}