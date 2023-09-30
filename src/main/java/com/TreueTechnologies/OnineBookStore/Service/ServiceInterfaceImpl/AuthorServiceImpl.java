package com.TreueTechnologies.OnineBookStore.Service.ServiceInterfaceImpl;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.AuthorRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.AuthorResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Author;
import com.TreueTechnologies.OnineBookStore.Entity.Book;
import com.TreueTechnologies.OnineBookStore.Repository.AuthorRepository;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {


    @Autowired
    AuthorRepository authorRepository;
    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) throws Exception {
        Author author=authorRepository.findByEmail(authorRequestDto.getEmail());
        if(author!=null){
            throw new Exception("Author Already Present");
        }
        // creating author object;
        Author author1=new Author();
        author1.setAuthorName(authorRequestDto.getAuthorName());
        author1.setAge(authorRequestDto.getAge());
        author1.setEmail(authorRequestDto.getEmail());
        author1.setMobileNo(authorRequestDto.getMobileNo());
        author1.setBookList(new ArrayList<>());

        Author author2=authorRepository.save(author1);   // saving author

        // creating authorResponseDto
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        authorResponseDto.setEmail(author2.getEmail());
        authorResponseDto.setMobileNo(author2.getMobileNo());
        authorResponseDto.setName(author2.getAuthorName());
        return authorResponseDto;
    }
}
