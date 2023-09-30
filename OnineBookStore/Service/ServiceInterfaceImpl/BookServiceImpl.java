package com.TreueTechnologies.OnineBookStore.Service.ServiceInterfaceImpl;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.BookRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.BookResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Author;
import com.TreueTechnologies.OnineBookStore.Entity.Book;
import com.TreueTechnologies.OnineBookStore.Enum.Status;
import com.TreueTechnologies.OnineBookStore.Repository.AuthorRepository;
import com.TreueTechnologies.OnineBookStore.Repository.BookRepository;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception {

        Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();
        if(author==null){
            throw new Exception("Author does not exist");
        }

        Book book=new Book();
        book.setBookName(bookRequestDto.getBookName());
        book.setDescription(bookRequestDto.getDescription());
        book.setPrice(bookRequestDto.getPrice());
        book.setGenre(bookRequestDto.getGenre());
        book.setQuantity(bookRequestDto.getQuantity());
        book.setAuthor(author);
        book.setStatus(Status.AVAILABLE);
        book.setReview(new ArrayList<>());
        book.setRatings(0);
        book.setCountOfRating(0);
        Book book1=bookRepository.save(book);


        author.getBookList().add(book1);
        authorRepository.save(author);
        return "Book Added Successfully";
    }

    @Override
    public BookResponseDto searchBookByName(String bookName) throws Exception {

        Book book=bookRepository.findByName(bookName);
        if(book==null){
            throw new Exception("Book does not exist");
        }

        BookResponseDto bookResponseDto=new BookResponseDto();
        bookResponseDto.builder().bookName(book.getBookName()).authorName(book.getAuthor().getAuthorName()).
                description(book.getDescription()).build();
        return bookResponseDto;

    }
}
