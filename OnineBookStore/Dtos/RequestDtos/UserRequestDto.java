package com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserRequestDto {


    String name;

    String email;

    String mobileNo;

    String age;
}
