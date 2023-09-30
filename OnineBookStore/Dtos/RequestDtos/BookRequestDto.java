package com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos;

import com.TreueTechnologies.OnineBookStore.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookRequestDto {

    String bookName;

    int price;

    String description;

    int authorId;

    Genre genre;

    int quantity;


}
