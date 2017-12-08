package com.example.demo.controllers;

import com.example.demo.models.Booking;
import com.example.demo.models.User_roles;
import com.example.demo.models.Users;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.User_rolesRepository;
import com.example.demo.services.BookingService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BookingController {


    @Autowired
    private User_rolesRepository user_rolesRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    public BookingService bookingService;

    public  void  setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Autowired
    public UserService userService;

    public void  setUserService(UserService userService) {this.userService = userService; }



    @RequestMapping(value = "/client/book", method = RequestMethod.GET)
    public String book(Model model) {


        return "client/bookingForm";
    }


    @RequestMapping(value = "/client/book", method = RequestMethod.POST)
    //@ResponseBody
    public String add(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String startdate = request.getParameter("startdate");
        String finishdate = request.getParameter("finishdate");//idete visi nahui
        String movie = request.getParameter("movie");
        String status = request.getParameter("status");


        model.addAttribute("username", username);
        model.addAttribute("status", status);
        model.addAttribute("movie", movie);
        model.addAttribute("startdate", startdate);


        Booking booking = new Booking();

        booking.setStartdate(startdate);
        booking.setFinishdate(finishdate);
        booking.setMovie(movie);
        booking.setUsers(userRepository.findOne(username));
        bookingRepository.save(booking);

       /* return "New booking" + username;*/
        return "client/feedback";

    }


    @RequestMapping(value = "/client/myBookings", method = RequestMethod.GET)
    public String myBookings(Model model) {

        model.addAttribute("bookings", bookingService.listAll());
        return "client/myBookings";
    }


    @RequestMapping(value = "/client/allBookings", method = RequestMethod.GET)
    public String allBookings(Model model) {

        model.addAttribute("bookings", bookingService.listAll());
        return "client/allBookings";
    }



    @RequestMapping("/client/delete/{id}")
    public String delete(@PathVariable String id, Model model){
        bookingService.delete(Integer.parseInt(id));
        model.addAttribute("bookings", bookingService.listAll());
        return "/client/myBookings";
    }


    @RequestMapping(value = "/client/myAccount", method = RequestMethod.POST)
    public String myAccount(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");

        model.addAttribute("account", userRepository.findOne(username));
        return "client/myAccount";
    }


    @RequestMapping("/client/deleteACC/{id}")
    @ResponseBody
    public String deleteACC(@PathVariable String id){




       int size = (int) user_rolesRepository.count();


        for (int i = 0 ; i < size; i++ ) {

            if (user_rolesRepository.findOne(i).getUsers().getUsername().equalsIgnoreCase(id)) {

                user_rolesRepository.delete(user_rolesRepository.findOne(i));
            }

        }

           userService.delete(id);

            return "Your account have been deleted Goodbye!!!! " + id ;
    }



}
