package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cusstomerId;

    private String mobilNo;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList =new ArrayList<>();

    public Customer() {
    }

    public Customer(int cusstomerId, String mobilNo, String password, List<TripBooking> tripBookingList) {
        this.cusstomerId = cusstomerId;
        this.mobilNo = mobilNo;
        this.password = password;
        this.tripBookingList = tripBookingList;
    }

    public Customer(int cusstomerId, String mobilNo, String password) {
        this.cusstomerId = cusstomerId;
        this.mobilNo = mobilNo;
        this.password = password;
    }

    public int getCusstomerId() {
        return cusstomerId;
    }

    public void setCusstomerId(int cusstomerId) {
        this.cusstomerId = cusstomerId;
    }

    public String getMobilNo() {
        return mobilNo;
    }

    public void setMobilNo(String mobilNo) {
        this.mobilNo = mobilNo;
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