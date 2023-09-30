package com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AuthorResponseDto {

    String name;

    String email;

    String mobileNo;

}
