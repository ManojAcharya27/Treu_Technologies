package com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderRequestDto {

    int userId;

    int bookId;

    int requiredQuantity;
}
