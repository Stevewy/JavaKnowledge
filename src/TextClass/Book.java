package TextClass;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author WangYao
 * @date 2019/11/25
 * @function
 */

public class Book implements Serializable, Cloneable/*, Comparable<Book> */{
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Book(){}

    public int compareTo(Book book) {
        if(this.equals(book)) return 0;
        return number.compareTo(book.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(number, book.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    public Book(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
