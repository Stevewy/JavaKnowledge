package collection.mapdemo;

import test.Book;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author WangYao
 * @date 2019/11/25
 * @function
 */
public class MapDemo {
    public static void main(String[] args) {

        HashMap<Book, Integer> hashBook = new HashMap<Book, Integer>(16, (float) 1.5);
        System.out.println(hashBook.put(new Book("你好", "1"), 3));
        System.out.println(hashBook.put(new Book("你好", "1"), 4));
        System.out.println(hashBook.put(new Book("不好", "1"), 3));
        System.out.println(hashBook.put(new Book("你好", "1"), 5));
        System.out.println(hashBook.put(new Book("你好", "2"), 6));
        /*
        相同key放进去会覆盖掉原本值
        4种遍历方式(foreach快!!!)
         */

        long t1 = System.nanoTime();
        Iterator<Book> it0 = hashBook.keySet().iterator();
        while (it0.hasNext()){
            Book b = it0.next();
            System.out.println(b + " " + hashBook.get(b));
        }
        long t2 = System.nanoTime();
        System.err.println(t2 - t1);

        long t3 = System.nanoTime();
        for(Book s : hashBook.keySet()){
            System.out.println(s + " " + hashBook.get(s));
        }
        long t4 = System.nanoTime();
        System.err.println(t4 - t3);

        long t5 = System.nanoTime();
        Iterator<Map.Entry<Book, Integer>> it = hashBook.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Book, Integer> m = it.next();
            System.out.println(m.getKey() + "  " + m.getValue());
        }
        long t6 = System.nanoTime();
        System.err.println(t6 - t5);

        long t7 = System.nanoTime();
        for(Map.Entry<Book, Integer> m : hashBook.entrySet()){
            System.out.println(m.getKey() + "  " + m.getValue());
        }
        long t8 = System.nanoTime();
        System.err.println(t8 - t7);

    }
}
