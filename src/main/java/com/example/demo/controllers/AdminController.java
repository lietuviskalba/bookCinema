package com.example.demo.controllers;

import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AdminController {


    @Autowired
    public BookingService bookingService;

    public  void  setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/admin/allBookings", method = RequestMethod.GET)
    public String allBookings(Model model) {
        model.addAttribute("bookings", bookingService.listAll());
        return "admin/allBookings";
    }

    @RequestMapping(value = "/admin/manage", method = RequestMethod.GET)
    public String manage(Model model) {

      return "admin/manage";
    }



}
