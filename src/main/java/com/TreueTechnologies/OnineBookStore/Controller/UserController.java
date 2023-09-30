package com.TreueTechnologies.OnineBookStore.Controller;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.BookRatingResponseDto;
import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.UserRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.BookResponseDto;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.BookService;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(UserRequestDto userRequestDto){
        try {
            String message = userService.addUser(userRequestDto);
            return new ResponseEntity(message, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getBookByName/{name}")
    public ResponseEntity getBookByName(@PathVariable("name") String bookName){
        try {
            BookResponseDto bookResponseDto=bookService.searchBookByName(bookName);
            return new ResponseEntity(bookResponseDto,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getByGenre/{Genre}")
    public ResponseEntity getBookByGenre(@PathVariable("Genre") String Genre){
        try {
            List<BookResponseDto> bookResponseDtoList=userService.getBookByGenre(Genre);
            return new ResponseEntity(bookResponseDtoList,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByAuthorName/{AuthorName}")
    public ResponseEntity getBookByAuthorName(@PathVariable("AuthorName")String AuthorName) {
        try {
            List<BookResponseDto> bookResponseDtoList = userService.getBookBYAuthorName(AuthorName);
            return new ResponseEntity<>(bookResponseDtoList, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/rateABook")
    public ResponseEntity rateABook(@RequestBody BookRatingResponseDto bookRatingResponseDto){
        try {
            String message=userService.rateABook(bookRatingResponseDto);
            return new ResponseEntity(message,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
