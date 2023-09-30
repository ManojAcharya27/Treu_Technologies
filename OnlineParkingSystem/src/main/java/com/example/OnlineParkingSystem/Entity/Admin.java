package com.example.OnlineParkingSystem.Entity;

import com.example.OnlineParkingSystem.Service.ServiceImpl.AdminServiceImpl;
import com.example.OnlineParkingSystem.Service.ServiceImpl.UserServiceImpl;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Admin {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

     String Name;

     String address;

     String email;

     String password;

     int noOfParkingSpots;

     ArrayList<AdminServiceImpl.Pair> parkingSpotsList;

}
