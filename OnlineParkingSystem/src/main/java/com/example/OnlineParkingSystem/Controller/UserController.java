package com.example.OnlineParkingSystem.Controller;

import com.example.OnlineParkingSystem.DTOs.RequestDto.UserRequestDto;
import com.example.OnlineParkingSystem.Service.ServiceImpl.AdminServiceImpl;
import com.example.OnlineParkingSystem.Service.ServiceInterface.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add_User")
    public ResponseEntity RegisterUser(@RequestBody UserRequestDto userRequestDto){
        // -- registering user----//
        try {
            String message=userService.RegisterUser(userRequestDto);
                return new ResponseEntity(message,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/search_ParkingSpot/{name}")
    public ResponseEntity searchParkingSpot(@PathVariable("name") String AdminName){
        try{
            ArrayList<AdminServiceImpl.Pair> ListOfAvailableParkingSpots=userService.searchParkingSpot(AdminName);
            return new ResponseEntity(ListOfAvailableParkingSpots,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/book_parkingSpot/{parkingSpotName}")
    public ResponseEntity bookParkingSpot(@PathVariable("parkingSpotName") String ParkingSpotName ,@PathParam("AdminName") String AdminName){
        try {
            String message=userService.bookParkingSpot(ParkingSpotName,AdminName);
            return new ResponseEntity(message,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST); 
        }
    }


}
