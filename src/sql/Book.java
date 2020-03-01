package sql;

import java.util.Date;

/**
 * @author WangYao
 * @date 2020/3/1
 * @function
 */
public class Book {
    private int id;
    private String bname;
    private String author;
    private double price;
    private Date publishDate;
    private int number;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
