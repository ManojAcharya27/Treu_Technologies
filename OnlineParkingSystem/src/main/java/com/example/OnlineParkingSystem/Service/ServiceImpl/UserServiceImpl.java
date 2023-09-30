package com.example.OnlineParkingSystem.Service.ServiceImpl;

import com.example.OnlineParkingSystem.DTOs.RequestDto.UserRequestDto;
import com.example.OnlineParkingSystem.Entity.Admin;
import com.example.OnlineParkingSystem.Entity.User;
import com.example.OnlineParkingSystem.Repository.AdminRepository;
import com.example.OnlineParkingSystem.Repository.UserRepository;
import com.example.OnlineParkingSystem.Service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;
    @Override
    public String RegisterUser(UserRequestDto userRequestDto) throws Exception {

   // ----- checking whether user already present or not -----
        User user2=userRepository.findBYEmail(userRequestDto.getEmail());
        if(user2!=null){
            throw  new Exception("User Already Registered");
        }

        User user=new User();


        // --------- transforming userRequestDto to actual user object ------
        user.setName(userRequestDto.getName());
        user.setAge(userRequestDto.getAge());
        user.setEmail(userRequestDto.getEmail());
        user.setMobileNo(userRequestDto.getMobileNo());
        user.setPassword(userRequestDto.getPassword());


        User user1=userRepository.save(user);

        return "Congrats ! for successfully  Registering.";
    }

    @Override
    public ArrayList<AdminServiceImpl.Pair> searchParkingSpot(String AdminName) throws Exception {

        Admin admin=adminRepository.findBYName(AdminName);
        if(admin==null){
            throw new Exception("Admin is Not Found");
        }
        ArrayList<AdminServiceImpl.Pair> ParkingSpotLists=admin.getParkingSpotsList();

        ArrayList<AdminServiceImpl.Pair> AvailableParkingSpots=new ArrayList<>();

        for(int i=0;i<ParkingSpotLists.size();i++){
            if(ParkingSpotLists.get(i).ActiveOrNot.equals("Available")){
                AvailableParkingSpots.add(new AdminServiceImpl.Pair(ParkingSpotLists.get(i).ParkingSpotName,ParkingSpotLists.get(i).ActiveOrNot));
            }
        }

        return AvailableParkingSpots;
    }

    @Override
    public String bookParkingSpot(String Name, String adminName) throws Exception {
        Admin admin=adminRepository.findBYName(adminName);
        if(admin==null){
            throw new Exception("Admin Not found");
        }

        ArrayList<AdminServiceImpl.Pair> parkingArrayList=admin.getParkingSpotsList();
        for(int i=0;i<parkingArrayList.size();i++){
            if(parkingArrayList.get(i).ParkingSpotName.equals(Name)&&parkingArrayList.get(i).ActiveOrNot.equals("Available")){
                String AvailableOrNot="Not Available";
                parkingArrayList.remove(i);
                parkingArrayList.add(new AdminServiceImpl.Pair(Name,AvailableOrNot));
                return "Booking Confirmed";
            }
        }
        return null;
    }


}
