package com.TreueTechnologies.OnineBookStore.Dtos.ResponseDto;

import com.TreueTechnologies.OnineBookStore.Entity.Item;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderResponseDto {

    String orderNo;

    int totalCost;

    Date orderDate;

    List<Item> items;

    String customerName;
}
