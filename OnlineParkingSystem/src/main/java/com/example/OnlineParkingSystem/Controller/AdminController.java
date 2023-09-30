package com.example.OnlineParkingSystem.Controller;

import com.example.OnlineParkingSystem.DTOs.RequestDto.AdminRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @PutMapping("/add_user")
    public ResponseEntity addAdmin(@RequestBody AdminRequestDto adminRequestDto){
        return null;
    }
}
