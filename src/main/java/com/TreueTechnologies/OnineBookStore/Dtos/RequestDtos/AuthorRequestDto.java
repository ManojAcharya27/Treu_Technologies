package com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AuthorRequestDto {
    String AuthorName;

    String email;

    String mobileNo;

    int age;
}
