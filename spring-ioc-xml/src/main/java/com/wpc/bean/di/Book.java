package com.wpc.bean.di;

/**
 * @author wpc
 * @date 2023/10/10 13:42
 */
public class Book {
    private String bname;
    private String author;
    private String others;

    public void setOthers(String others) {
        this.others = others;
    }

    public Book(String bname, String author, String others) {
        this.bname = bname;
        this.author = author;
        this.others = others;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }


    public Book() {
        System.out.println("无参构造执行了");
    }

    public void setAuthor(String author) {
        System.out.println("set注入");
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {


    }
}
