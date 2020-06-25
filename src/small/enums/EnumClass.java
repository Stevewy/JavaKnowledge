package small.enums;

/**
 * @author WangYao
 * @date 2020/6/24
 * @function 枚举类的一些用法
 */

enum Shrubbery {GROUND, CRAWLING, HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()){ //values是编译器插入static方法
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING)); // - 0 +
            System.out.println(s.equals(Shrubbery.CRAWLING)); // false true
            System.out.println(s == Shrubbery.CRAWLING); //false true
            System.out.println(s.getDeclaringClass() + " " + s.name());
            System.out.println("------------------------");
        }

        for (String s : "GROUND CRAWLING HANGING".split(" ")){
            Shrubbery sh = Enum.valueOf(Shrubbery.class, s);
            System.out.println(sh);
        }
    }
}
