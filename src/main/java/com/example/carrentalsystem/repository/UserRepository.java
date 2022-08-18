package com.example.carrentalsystem.repository;

import com.example.carrentalsystem.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    public UserEntity findByUsername(String username);
}