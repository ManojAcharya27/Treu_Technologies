package com.TreueTechnologies.OnineBookStore.Service.ServiceInterfaceImpl;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.BookRatingResponseDto;
import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.UserRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.BookResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Author;
import com.TreueTechnologies.OnineBookStore.Entity.Book;
import com.TreueTechnologies.OnineBookStore.Entity.User;
import com.TreueTechnologies.OnineBookStore.Repository.AuthorRepository;
import com.TreueTechnologies.OnineBookStore.Repository.BookRepository;
import com.TreueTechnologies.OnineBookStore.Repository.UserRepository;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.AuthorService;
import com.TreueTechnologies.OnineBookStore.Service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    @Override

    public String addUser(UserRequestDto userRequestDto) throws Exception {
        User user;
        user=userRepository.findByEmail(userRequestDto.getEmail());
        if(user!=null){
            throw new Exception("User Already Registered");
        }

        User user1=new User();
        user1.builder().age(userRequestDto.getAge()).name(userRequestDto.getName()).email(userRequestDto.getEmail()).
                mobileNo(userRequestDto.getMobileNo()).build();
        User user2=userRepository.save(user1);
        return "User Registered";
    }

    @Override
    public List<BookResponseDto> getBookByGenre(String genre) {

        List<Book> bookList=bookRepository.findAll();
        List<BookResponseDto> bookResponseDtoList=new ArrayList<>();
        for(int i=0;i<bookList.size();i++){

            Book book=bookList.get(i);
            if(book.getGenre().equals(genre)) {
                BookResponseDto bookResponseDto = new BookResponseDto();
                bookResponseDto.builder().bookName(book.getBookName()).authorName(book.getAuthor().getAuthorName()).
                        description(book.getDescription()).build();
                bookResponseDtoList.add(bookResponseDto);
            }

        }
        return bookResponseDtoList;
    }

    @Override
    public List<BookResponseDto> getBookBYAuthorName(String AuthorName) throws Exception {

        Author author=authorRepository.findByName(AuthorName);
        if(author==null){
            throw new Exception("Author Does Not Exist");
        }
        List<Book> bookList=author.getBookList();
        List<BookResponseDto> bookResponseDtoList=new ArrayList<>();
        for(int i=0;i<bookList.size();i++){
            Book book=bookList.get(i);

            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.builder().bookName(book.getBookName()).authorName(book.getAuthor().getAuthorName()).
                    description(book.getDescription()).build();
            bookResponseDtoList.add(bookResponseDto);

        }
        return bookResponseDtoList;
    }

    @Override
    public String rateABook(BookRatingResponseDto bookRatingResponseDto) throws Exception {

        Book book=bookRepository.findById(bookRatingResponseDto.getBookId()).get();
        if(book==null){
            throw new Exception("Book does not exist");
        }
        if(bookRatingResponseDto.getRatings()>5||bookRatingResponseDto.getRatings()<0){
            throw new Exception("Rting value should be under 5 and greater than 0");
        }

        book.getReview().add(bookRatingResponseDto.getReview());
        int rating=book.getRatings();
        int countOfRatings=book.getCountOfRating();

        if(countOfRatings==0){
            book.setRatings(bookRatingResponseDto.getRatings());
            countOfRatings++;
            book.setCountOfRating(countOfRatings);
        }else{
            rating=(rating+bookRatingResponseDto.getRatings()/(countOfRatings+1));
            book.setRatings(rating);
            book.setCountOfRating(countOfRatings+1);
        }
        bookRepository.save(book);
        return "Thank you for Review";
    }
}
