package com.example.demo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity(name = "Book")
@Table(name = "book",uniqueConstraints={
        @UniqueConstraint(name = "Book_Id_unique",columnNames = "id")
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_sequence")
    @SequenceGenerator(name = "Book_sequence",sequenceName = "Book_sequence",allocationSize = 1)
    @Column(name = "id",unique = false)
    private Long id;

    @Column(name = "IsBn_number")
    private String isBn;

    @OneToOne(mappedBy = "book")
     private BookRecord bookRecord;


    public Book() {

    }
    public Book(String isBn, BookRecord bookRecord) {
        this.isBn = isBn;
        this.bookRecord = bookRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsBn() {
        return isBn;
    }

    public void setIsBn(String isBn) {
        this.isBn = isBn;
    }

    public BookRecord getBookRecord() {
        return bookRecord;
    }

    public void setBookRecord(BookRecord bookRecord) {
        this.bookRecord = bookRecord;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isBn='" + isBn + '\'' +
                ", bookRecord=" + bookRecord +
                '}';
    }

   }
