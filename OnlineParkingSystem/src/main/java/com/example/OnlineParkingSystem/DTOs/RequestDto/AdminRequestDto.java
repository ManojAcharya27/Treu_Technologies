package com.example.OnlineParkingSystem.DTOs.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AdminRequestDto {

    String Name;

    String address;

    String email;

    String password;

    int noOfParkingSpots;
}
