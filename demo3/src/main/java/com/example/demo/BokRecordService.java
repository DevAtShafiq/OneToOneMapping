package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BokRecordService {

    @Autowired
    BookRecordRepository bookRecordRepository;

    public BookRecord saveBookRecord( BookRecord bookRecord){

        Book book =new Book();
        book.getId();
        book.getIsBn();

        bookRecord.getBook(book);

        BookRecord savedBook = bookRecordRepository.save(bookRecord);
        return  savedBook;
    }

   public List<BookRecord>getAllRecord(){
        return bookRecordRepository.findAll();
    }


    }

