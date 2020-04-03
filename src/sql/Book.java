package sql;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author WangYao
 * @date 2020/3/1
 * @function
 */
@Getter
@Setter
public class Book {
    private int id;
    private String bname;
    private String author;
    private double price;
    private Date publishDate;
    private int number;

    public Book() {
    }

    public Book(int id, String bname, String author, double price, Date publishDate, int number) {
        this.id = id;
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.number = number;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", number=" + number +
                '}';
    }
}
