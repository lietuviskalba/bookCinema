package com.example.demo.repositories;

import com.example.demo.models.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository  extends CrudRepository<Booking, Integer> {
}
