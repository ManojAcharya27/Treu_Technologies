package com.TreueTechnologies.OnineBookStore.Controller;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.AuthorRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.AuthorResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Author;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/addAuthor")
    public ResponseEntity addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        try {
            AuthorResponseDto authorResponseDto=authorService.addAuthor(authorRequestDto);
            return new ResponseEntity<>(authorResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
