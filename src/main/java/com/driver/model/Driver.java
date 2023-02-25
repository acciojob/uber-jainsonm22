package com.driver.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int driverID;
    private String mobileNo;
    private String password;

    @OneToOne
    @JoinColumn
    private Cab cab;

   @OneToMany(mappedBy = "driver" ,cascade = CascadeType.ALL)
   List<TripBooking> tripBookingList = new ArrayList<>();

    public Driver() {
    }

    public Driver(String mobileNo, String password) {
        this.mobileNo = mobileNo;
        this.password = password;
    }

    public Driver(int driverID, String mobileNo, String password, Cab cab, List<TripBooking> tripBookingList) {
        this.driverID = driverID;
        this.mobileNo = mobileNo;
        this.password = password;
        this.cab = cab;
        this.tripBookingList = tripBookingList;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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