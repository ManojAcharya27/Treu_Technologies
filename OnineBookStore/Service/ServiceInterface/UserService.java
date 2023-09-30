package com.TreueTechnologies.OnineBookStore.Service.ServiceInterface;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.BookRatingResponseDto;
import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.UserRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.BookResponseDto;
import com.TreueTechnologies.OnineBookStore.Entity.Book;

import java.util.List;

public interface UserService {

    public String addUser(UserRequestDto userRequestDto) throws Exception;


    public List<BookResponseDto> getBookByGenre(String genre);

    public List<BookResponseDto> getBookBYAuthorName(String AuthorName) throws Exception;


    public String rateABook(BookRatingResponseDto BookRatingResponseDto) throws Exception;
}
