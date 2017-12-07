package com.example.demo.services;

import com.example.demo.models.Booking;
import com.example.demo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {


    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;

    }


    @Override
    public List<Booking> listAll() {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }



    @Override
    public Booking getById(int id) {
        return  bookingRepository.findOne(id);
    }

    @Override
    public void delete(int id) {

        bookingRepository.delete(id);
    }

    public Booking saveOrUpdate(Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

}
