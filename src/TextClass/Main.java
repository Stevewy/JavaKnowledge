package TextClass;

import java.io.IOException;

/**
 * @author WangYao
 * @date 2019/11/30
 * @function
 */
public class Main {
    private int 傻 = 250;
    private int 你 = 傻;
    {System.out.println(你);}

    int x = 1;

    enum E{
        SMALL(" S"),MEDIUM("M");
        private String k;

        private E(String k){
            this.k = k;
        }

        public String getK() {
            return k;
        }
    }

//    private static String statics = "静态块";
//    static {System.out.println(statics);}

    public static void main(String... args) throws IOException {

        System.out.println(Integer.toHexString(15));



        /*
         * 块和静态块
         */
//        Main m = new Main();//访问对象
//        Main m1 = new Main();//访问对象
        //访问静态成员

        /*
         * 日志写到文件
         */
//        Logger l = Logger.getLogger("com.wy");
//        l.setLevel(Level.ALL);
//        FileHandler f = new FileHandler("Journal//Journal.txt");
//        l.addHandler(f);
//        l.log(Level.WARNING, "警告???");

        /*
         * 日志的使用
         */
//        try {
//            throw new Exception("哈哈");
//        }
//        catch (Exception e){
//            l.log(Level.WARNING, "read" , e);
//            l.throwing("TextClass.Main", "read", e);
//        }

        /*
         * ...的使用
         */
//        if(t-- == 1)
//            TextClass.Main.main("asd","sad","few","fewa");
//        else
//            for(String s : args)
//                System.out.println(s);

        /*
         * 枚举
         */
//        E s = Enum.valueOf(E.class, "SMALL");
//        E[] es = E.values();

        /*
         * Compare与Comparable
         */
//        Book[] books = {new Book("a","1"), new Book("b","11"), new Book("a","2")};
//        Arrays.sort(books);                            //自己Comparable
//        Arrays.sort(books, new BookCompare());         //有一个类
//        Arrays.sort(books, new Comparator<Book>() {    //匿名内部类
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getNumber().compareTo(o2.getNumber());
//            }
//        });
//        Arrays.sort(books, Comparator.comparing(Book::getName).thenComparing(Book::getNumber));   //最好用,Compare里面的静态方法
//        for(Book b : books){
//            System.out.println(b);
//        }

        /*
         * BigInteger  BigDecimal
         */
//        BigInteger i = new BigInteger("-+153645363565436");
//        System.out.println(i);

        /*
         * 创建文件
         */
//        try {
//            FileOutputStream o = new FileOutputStream("Book\\book.txt");
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }

        /*
         * 测试用时for与foreach那个快
         */
//        int a[] = new int[10000];
//        long f = System.nanoTime();
//        for(int i = 0; i < 10000; i++){
//            a[i] = 1;
//        }
//        for(int i = 0; i < 10000; i++){
//            a[i] -= 1;
//        }
//        long l = System.nanoTime();
//        System.out.println("1 " + (l - f));
//        long f2 = System.nanoTime();
//        for(int i : a){
//            i = 1;
//        }
//        for(int i : a){
//            i -= 1;
//        }
//        long l2 = System.nanoTime();
//        System.out.println("2 " + (l2 - f2));

    }
}