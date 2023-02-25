package com.driver.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int DriverId;
    private String Mobile;
    private String password;

    @OneToOne
    @JoinColumn
    private Cab cab;

   @OneToMany(mappedBy = "driver" ,cascade = CascadeType.ALL)
   List<TripBooking> tripBookingList = new ArrayList<>();

    public Driver() {
    }

    public Driver(String Mobile, String password) {
        this.Mobile = Mobile;
        this.password = password;
    }

    public Driver(int DriverId, String Mobile, String password, Cab cab, List<TripBooking> tripBookingList) {
        this.DriverId = DriverId;
        this.Mobile = Mobile;
        this.password = password;
        this.cab = cab;
        this.tripBookingList = tripBookingList;
    }

    public int getDriverId() {
        return DriverId;
    }

    public void setDriverId(int driverId) {
        DriverId = driverId;
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

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }
}