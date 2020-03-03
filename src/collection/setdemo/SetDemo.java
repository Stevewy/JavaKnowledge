package collection.setdemo;

import testclass.Book;
import testclass.BookCompare;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author WangYao
 * @date 2019/12/7
 * @function
 */
public class SetDemo {

    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>(new BookCompare());
        books.add(new Book("a","1"));
        books.add(new Book("a","12"));
        System.out.println(books);

        HashSet<Book> books1 = new HashSet<>();
        books1.add(new Book("a","1"));
        books1.add(new Book("a","12"));
        System.out.println(books1);

        LinkedHashSet<Book> books2 = new LinkedHashSet<>();
    }
}