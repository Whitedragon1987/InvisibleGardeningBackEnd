package com.example.invisiblegardening.repositories;

import com.example.invisiblegardening.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}