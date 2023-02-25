package com.driver.model;

import javax.persistence.*;

@Entity
public class Cab{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int perKmRate;
    private boolean isAvailable;

    @OneToOne(mappedBy = "cab" , cascade = CascadeType.ALL)
    private Driver driver;

    public Cab() {
    }

    public Cab(int perKmRate) {
        this.perKmRate = perKmRate;
    }

    public Cab(int id, int perKmRate, boolean isAvailable, Driver driver) {
        this.id = id;
        this.perKmRate = perKmRate;
        this.isAvailable = isAvailable;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerKmRate() {
        return perKmRate;
    }

    public void setPerKmRate(int perKmRate) {
        this.perKmRate = perKmRate;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}