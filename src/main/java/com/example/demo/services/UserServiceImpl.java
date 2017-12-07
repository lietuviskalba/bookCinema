package com.example.demo.services;

import com.example.demo.models.Booking;
import com.example.demo.models.Users;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public List<Users> listAll() {
        return null;
    }

    @Override
    public Users getById(String id) {
        return  userRepository.findOne(id);
    }

    @Override
    public Users saveOrUpdate(Users course) {
        return null;
    }

    @Override
    public void delete(String id) {

        userRepository.delete(id);

    }



}
