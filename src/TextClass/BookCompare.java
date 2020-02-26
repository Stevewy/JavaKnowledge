package TextClass;

import TextClass.Book;

import java.util.Comparator;

/**
 * @author WangYao
 * @date 2019/12/7
 * @function
 */
public class BookCompare implements Comparator <Book> {

    public int compare(Book book, Book anotherBook){
        return book.getNumber().compareTo(anotherBook.getNumber());
    }

}
