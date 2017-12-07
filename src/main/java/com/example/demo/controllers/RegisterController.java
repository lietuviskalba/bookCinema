package com.example.demo.controllers;



import com.example.demo.models.User_roles;
import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.User_rolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private User_rolesRepository user_rolesRepository;



    @RequestMapping(value = "/register",method = RequestMethod.POST)
   // @ResponseBody
    public  String add(HttpServletRequest request, Model model){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dormRoom = request.getParameter("dormRoom");
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("dormRoom",dormRoom);



        Users users = new Users();

        users.setEnabled(1);
        users.setUsername(username);
        users.setPassword(password);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setDormRoom(Integer.parseInt(dormRoom));

        userRepository.save(users);

        User_roles user_roles = new User_roles();
        user_roles.setRole("ROLE_USER");
        user_roles.setUsers(userRepository.findOne(username));

        user_rolesRepository.save(user_roles);

        return "feedback";
   // return "New user was added" + username + password +firstName +lastName;

    }



}
