package com.driver.model;
import com.driver.model.TripStatus;
import javax.persistence.*;

@Entity
public class TripBooking{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TripBookingId;

    private String FromLocation;
    private String toLocation;

    private int distanceInKm;
    private int bill;

    @Enumerated(EnumType.STRING)
    private TripStatus Status;

    @ManyToOne
    @JoinColumn
    private Driver driver;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    public TripBooking() {
    }

    public TripBooking(int TripBookingId, String FromLocation, String toLocation, int distanceInKm, int bill, TripStatus Status) {
        this.TripBookingId = TripBookingId;
        this.FromLocation = FromLocation;
        this.toLocation = toLocation;
        this.distanceInKm = distanceInKm;
        this.bill = bill;
        this.Status = Status;
    }

    public int getTripBookingId() {
        return TripBookingId;
    }

    public void setTripBookingId(int TripBookingId) {
        this.TripBookingId = TripBookingId;
    }

    public String getFromLocation() {
        return FromLocation;
    }

    public void setFromLocation(String fromLocation) {
        FromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public TripStatus getStatus() {
        return Status;
    }

    public void setStatus(TripStatus status) {
        Status = status;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}