package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BokRecordService bookRecordService;
    @Autowired
    BookRecordRepository bookRecordRepository;

    @PostMapping("/newBook")
    public ResponseEntity<?> saveBookRecord( @RequestBody BookRecord bookRecord) {


        boolean exist = bookRecordRepository.existsById(bookRecord.getId());
        if (exist) {
            return ResponseEntity.status(409).body("already exist");
        } else {
            bookRecordService.saveBookRecord(bookRecord);
               return ResponseEntity.status(202).body(bookRecord);
        }}


    @GetMapping("/allBook")
    public List<BookRecord>bookRecords(){


        List<BookRecord> allRecord = bookRecordService.getAllRecord();
        return allRecord;

    }

    }




