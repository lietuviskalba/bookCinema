package com.example.demo.services;


import com.example.demo.models.Users;

import java.util.List;

public interface UserService {

    List<Users> listAll();

    Users getById(String id);

    Users saveOrUpdate(Users course);

    void delete(String id);


}
