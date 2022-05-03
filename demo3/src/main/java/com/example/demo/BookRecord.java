package com.example.demo;

import javax.persistence.*;


@Entity(name = "BookRecord")
@Table(name = "bookRecord",uniqueConstraints = {
        @UniqueConstraint(name = "record_id",columnNames = "id")
})
public class BookRecord {
    @Id
    @SequenceGenerator(name = "bookRecord_generator",sequenceName= "book_record_generator",allocationSize = 1)

@Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "price")
    private Long price;
    @Column(name = "url")
    private String url;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId",
    referencedColumnName = "id")
    private Book book;

    public BookRecord() {
    }

    public BookRecord(String title, String author, String publisher, Long price, String url, Book book) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.url = url;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Book getBook(Book book) {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookRecord{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", book=" + book +
                '}';
    }
}
