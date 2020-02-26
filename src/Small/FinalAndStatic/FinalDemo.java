package Small.FinalAndStatic;

import TextClass.Book;

import java.util.Random;

/**
 * @author WangYao
 * @date 2019/12/29
 * @function
 */
public class FinalDemo {
    private final int a1 = 1;
    private static Random r = new Random();
    private final int a2 = r.nextInt(50);
    private static final int a3 = r.nextInt(50);
    private final Book b = new Book("1", "1");

    private void f1(){
        b.setName("2");
    }


    public static void main(String[] args) {
        /**
         * final并非是写代码时确定
         */
        FinalDemo f1 = new FinalDemo();
        System.out.println(f1.a2 + "  " + a3);
//        System.out.println(f1.b);
//        f1.f1();
//        System.out.println(f1.b);

        FinalDemo f2 = new FinalDemo();
        System.out.println(f2.a2 + "  " + a3);
//        System.out.println(f2.b);
    }
}
