package com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto;

import com.TreueTechnologies.OnineBookStore.Entity.Item;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponseDto {
    int totalNoOfItem;

    int TotalCost;

    String userName;

    List<Item> itemList=new ArrayList<>();
}
