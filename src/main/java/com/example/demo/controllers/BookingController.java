package com.example.demo.controllers;

import com.example.demo.models.User_roles;
import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.User_rolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BookingController {




    @RequestMapping(value = "/client/book",method = RequestMethod.GET)
    public  String book(Model model) {



        return "client/bookingForm";
    }




    @RequestMapping(value = "/client/book", method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String time = request.getParameter("time");
        String date = request.getParameter("date");

        model.addAttribute("username", username);



        return "New booking" + username ;
        /*return "client/bookingForm";*/

    }
}





//    model.addAttribute("courses", courseService.listAll());


