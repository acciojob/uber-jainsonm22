package com.driver.model;
import com.driver.model.TripStatus;
import javax.persistence.*;

@Entity
public class TripBooking{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TripBookingId;

    private String fromLoaction;
    private String toLocation;

    private int distanceInKm;
    private int bill;

    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;

    @ManyToOne
    @JoinColumn
    private Driver driver;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    public TripBooking() {
    }

    public TripBooking(int TripBookingId, String fromLoaction, String toLocation, int distanceInKm, int bill, TripStatus tripStatus) {
        this.TripBookingId = TripBookingId;
        this.fromLoaction = fromLoaction;
        this.toLocation = toLocation;
        this.distanceInKm = distanceInKm;
        this.bill = bill;
        this.tripStatus = tripStatus;
    }

    public int getTripBookingId() {
        return TripBookingId;
    }

    public void setTripBookingId(int TripBookingId) {
        this.TripBookingId = TripBookingId;
    }

    public String getFromLoaction() {
        return fromLoaction;
    }

    public void setFromLoaction(String fromLoaction) {
        this.fromLoaction = fromLoaction;
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

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
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