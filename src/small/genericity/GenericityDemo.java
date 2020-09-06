package small.genericity;

import testclass.Book;

import java.util.ArrayList;

/**
 * @author WangYao
 * @date 2020/1/7
 * @function 类构造器
 */
public class GenericityDemo <T> {

    public static <E> E get(Class<E> type){  //给一个类型信息,得到一个对象(前提有默认构造器且可用)
        try {
            return type.getDeclaredConstructor().newInstance();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <E> ArrayList<E> getArrayList(){
        return new ArrayList<E>();
    }

    public static void main(String[] args) {
        ArrayList<Book> book = new ArrayList</*book*/>();
        ArrayList<Book> books = GenericityDemo./*<book>*/getArrayList();
    }
}
