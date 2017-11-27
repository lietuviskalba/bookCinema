package com.example.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="User_roles")
public class User_roles {

    @Id
    @GeneratedValue
    private int user_role_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users users;



    private String role;



}
