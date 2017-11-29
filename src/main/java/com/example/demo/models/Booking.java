package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Booking {


    @Id
    private int id;
    private String startdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    private String finishdate;
    private String movie;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users users;

}
