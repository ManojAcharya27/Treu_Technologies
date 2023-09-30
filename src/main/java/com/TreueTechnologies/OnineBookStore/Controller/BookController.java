package com.TreueTechnologies.OnineBookStore.Controller;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.BookRequestDto;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {


    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
        try {
            String message=bookService.addBook(bookRequestDto);
            return new ResponseEntity(message, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
