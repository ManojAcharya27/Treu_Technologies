package com.TreueTechnologies.OnineBookStore.Service.ServiceInterface;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.BookRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.BookResponseDto;

public interface BookService {

    public String addBook(BookRequestDto bookRequestDto) throws Exception;

    public BookResponseDto searchBookByName(String bookName) throws Exception;
}
