package com.example.demo.repositories;
import com.example.demo.models.Users;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Users, String> {
}




