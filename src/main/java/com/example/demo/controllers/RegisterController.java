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
    @ResponseBody
    public  String add(HttpServletRequest request, Model model){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        model.addAttribute("username",username);


        Users users = new Users();

        users.setEnabled(1);
        users.setUsername(username);
        users.setPassword(password);
        users.setFirstName(firstName);
        users.setLastName(lastName);

        userRepository.save(users);

        User_roles user_roles = new User_roles();
        user_roles.setRole("ROLE_USER");
        user_roles.setUsers(userRepository.findOne(username));

        user_rolesRepository.save(user_roles);


    return "New user was added" + username + password +firstName +lastName;

    }















   /* @Autowired
    public BookingService bookingService;

    public  void  setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Autowired
    private BookingRepository bookingRepository;




    @Autowired
    private StudentRepository studentRepository;



    @RequestMapping(value = "/administrator/add")
    public  String studentAdd() {
        return "/administrator/addStudent";
    }


*//*
    @RequestMapping(value = "/administrator/list")
    public  String list() {
        return "/administrator/list";
    }
*//*


    @RequestMapping("/administrator/list")
    public  String listBookings(Model model) {
        model.addAttribute("bookings", bookingService.listAll());

        return "/administrator/list";
    }




    @RequestMapping(value = "/administrator/menu")
    public  String menu() {
        return "/administrator/menu";
    }


    @RequestMapping(value = "/administrator/add",method = RequestMethod.POST)
    //@ResponseBody
    public  String add(HttpServletRequest request, Model model){

        String studentFirstName = request.getParameter("studentFirstName");
        String studentLastName = request.getParameter("studentLastName");

        model.addAttribute("studentFirstName",studentFirstName);

        Student student = new Student();


        student.setStudentFirstName(studentFirstName);
        student.setStudentLastName(studentLastName);
        student.setStudEmail(studentFirstName+"@stud.kea.dk");
        student.setStudPassword("password");

        studentRepository.save(student);

        return "administrator/menu";

    *//*    return "student was added :" + studentFirstName; //just to make sure*//*

    }

    @RequestMapping("/administrator/delete/{id}")
    public String delete(@PathVariable String id, Model model){
        bookingService.delete(Long.valueOf(id));
        model.addAttribute("bookings", bookingService.listAll());
        return "/administrator/list";
    }


    @RequestMapping("/administrator/approve/{id}")
    public String approve(@PathVariable String id, Model model){
        // bookingService.getById(Long.valueOf(id)).setStatus("Approved");
        model.addAttribute("bookings", bookingService.listAll());

        Booking booking = new Booking();
        booking.setStatus("approved");
        booking.set_id(  bookingService.getById(Long.valueOf(id)).get_id());
        booking.setCourse(   bookingService.getById(Long.valueOf(id)).getCourse());
        booking.setStudent(  bookingService.getById(Long.valueOf(id)).getStudent() );
        booking.setTimestamp(  bookingService.getById(Long.valueOf(id)).getTimestamp()  );


        bookingRepository.save(booking);

        return "/administrator/list";
    }

    @RequestMapping("/administrator/disapprove/{id}")
    public String disapprove(@PathVariable String id, Model model){
        // bookingService.getById(Long.valueOf(id)).setStatus("Disapproved");
        model.addAttribute("bookings", bookingService.listAll());

        Booking booking = new Booking();
        booking.setStatus("disapproved");
        booking.set_id(  bookingService.getById(Long.valueOf(id)).get_id());
        booking.setCourse(   bookingService.getById(Long.valueOf(id)).getCourse());
        booking.setStudent(  bookingService.getById(Long.valueOf(id)).getStudent() );
        booking.setTimestamp(  bookingService.getById(Long.valueOf(id)).getTimestamp()  );


        bookingRepository.save(booking);



        return "/administrator/list";
    }

*/
}
