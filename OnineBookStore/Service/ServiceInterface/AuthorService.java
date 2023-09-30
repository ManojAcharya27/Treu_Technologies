package com.TreueTechnologies.OnineBookStore.Service.ServiceInterface;

import com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos.AuthorRequestDto;
import com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto.AuthorResponseDto;

public interface AuthorService {

    public  AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) throws Exception;
}
