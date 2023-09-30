package com.TreueTechnologies.OnineBookStore.Dtos.RequestDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemRequestDto {
    int userId;
    int BookId;
    int requiredQuantity;

}
