package com.example.OnlineParkingSystem.Repository;

import com.example.OnlineParkingSystem.Entity.Admin;
import com.example.OnlineParkingSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByEmail(String email);

    Admin findBYName(String name);
}
