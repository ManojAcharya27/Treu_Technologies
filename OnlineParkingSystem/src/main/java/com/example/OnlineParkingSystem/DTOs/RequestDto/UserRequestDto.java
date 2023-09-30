package com.example.OnlineParkingSystem.DTOs.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserRequestDto {
    String name;

    int age;

    String email;

    String mobileNo;

    String password;


}
