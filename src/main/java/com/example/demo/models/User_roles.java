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

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users users;
    private String role;



}
