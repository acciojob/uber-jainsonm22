package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CustomerId;

    private String Mobile;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList =new ArrayList<>();

    public Customer() {
    }

    public Customer(int CustomerId, String Mobile, String password, List<TripBooking> tripBookingList) {
        this.CustomerId = CustomerId;
        this.Mobile = Mobile;
        this.password = password;
        this.tripBookingList = tripBookingList;
    }

    public Customer(int CustomerId, String Mobile, String password) {
        this.CustomerId = CustomerId;
        this.Mobile = Mobile;
        this.password = password;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }


    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }
}