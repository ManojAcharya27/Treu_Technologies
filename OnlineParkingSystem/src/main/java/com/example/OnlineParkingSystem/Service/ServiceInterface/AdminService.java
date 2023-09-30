package com.example.OnlineParkingSystem.Service.ServiceInterface;

import com.example.OnlineParkingSystem.DTOs.RequestDto.AdminRequestDto;

public interface AdminService {

    public String addAdmin(AdminRequestDto adminRequestDto) throws Exception;
}
