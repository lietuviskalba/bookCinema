package com.example.demo.services;

import com.example.demo.models.Booking;


import java.util.List;

public interface BookingService  {

    List<Booking> listAll();

    Booking getById(int id);

    void delete(int id);

    Booking saveOrUpdate(Booking booking);
}

