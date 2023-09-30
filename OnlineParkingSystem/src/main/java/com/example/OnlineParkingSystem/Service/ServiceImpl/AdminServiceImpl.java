package com.example.OnlineParkingSystem.Service.ServiceImpl;

import com.example.OnlineParkingSystem.DTOs.RequestDto.AdminRequestDto;
import com.example.OnlineParkingSystem.Entity.Admin;
import com.example.OnlineParkingSystem.Repository.AdminRepository;
import com.example.OnlineParkingSystem.Service.ServiceInterface.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public String addAdmin(AdminRequestDto adminRequestDto) throws Exception {

        Admin admin=adminRepository.findByEmail(adminRequestDto.getEmail());
        if(admin!=null){
            throw new Exception("Admin Already Present");
        }

        Admin admin1=new Admin();
        admin1.setName(adminRequestDto.getName());
        admin1.setEmail(adminRequestDto.getEmail());
        admin1.setAddress(adminRequestDto.getAddress());
        admin1.setPassword(admin1.getPassword());
        admin1.setNoOfParkingSpots(adminRequestDto.getNoOfParkingSpots());
        ArrayList<Pair>ParkingList =new ArrayList<>();
        for(int i=1;i<=adminRequestDto.getNoOfParkingSpots();i++){
            String ParkingSpotName="ParkingSpot"+i;
            String ActiveOrNot="Available";
            ParkingList.add(new Pair(ParkingSpotName,ActiveOrNot));
        }
        admin1.setParkingSpotsList(ParkingList);

        adminRepository.save(admin1);





        return "Successfully Registered";
    }
    public static class  Pair {
        String ParkingSpotName;

        String ActiveOrNot;
        public Pair(String ParkingSpotName,String ActiveOrNot){
            this.ParkingSpotName=ParkingSpotName;
            this.ActiveOrNot=ActiveOrNot;
        }
    }
}


