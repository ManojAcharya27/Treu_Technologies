package com.example.OnlineParkingSystem.Service.ServiceInterface;

import com.example.OnlineParkingSystem.DTOs.RequestDto.UserRequestDto;


import com.example.OnlineParkingSystem.Service.ServiceImpl.AdminServiceImpl;

import java.util.ArrayList;

public interface UserService {

    public String RegisterUser(UserRequestDto userRequestDto) throws Exception;

    public ArrayList<AdminServiceImpl.Pair> searchParkingSpot(String AdminName) throws Exception;

    public String  bookParkingSpot(String Name,String adminName) throws Exception;
}
