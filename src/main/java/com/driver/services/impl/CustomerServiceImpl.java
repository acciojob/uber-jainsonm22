package com.driver.services.impl;

import com.driver.model.*;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer customer=customerRepository2.findById(customerId).get();
		List<TripBooking> tripBookingList=customer.getTripBookingList();
		for(TripBooking tripBooking:tripBookingList){
			if(tripBooking.getTripStatus()==TripStatus.CONFIRMED){
				tripBooking.setTripStatus(TripStatus.CANCELED);
			}

		}
        customerRepository2.delete(customer);

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query

		TripBooking tripBooking =new TripBooking();
		Driver driver=null;
		List<Driver> driverList =driverRepository2.findAll();
		for(Driver driver1: driverList){
			if(driver1.getCab().getIsAvailable()==true){
				if(driver== null ||(driver.getDriverID() >driver1.getDriverID()))
				{
					driver=driver1;
				}
			}
		}
		if(driver==null){
			throw new Exception("no cab available !");
		}

		Customer customer=customerRepository2.findById(customerId).get();
		tripBooking.setCustomer(customer);
		tripBooking.setDriver(driver);
		tripBooking.setFromLoaction(fromLocation);
		tripBooking.setToLocation(toLocation);
		tripBooking.setTripStatus(TripStatus.CONFIRMED);
		driver.getCab().setIsAvailable(false);
		tripBooking.setDistanceInKm(distanceInKm);
		int rate =driver.getCab().getPerKmRate();
		tripBooking.setBill(rate*distanceInKm);

		customer.getTripBookingList().add(tripBooking);
		driverRepository2.save(driver);
		return tripBooking;

	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking tripBooking=tripBookingRepository2.findById(tripId).get();
		tripBooking.setTripStatus(TripStatus.CANCELED);
        tripBooking.setBill(0);
		tripBooking.getDriver().getCab().setIsAvailable(true);
		tripBookingRepository2.save(tripBooking);


	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking tripBooking=tripBookingRepository2.findById(tripId).get();
		tripBooking.setTripStatus(TripStatus.COMPLETED);
		int distance=tripBooking.getDistanceInKm();

		Driver driver= tripBooking.getDriver();
		Cab cab=driver.getCab();
		int rate =cab.getPerKmRate();
		tripBooking.setBill(distance*rate);
		tripBooking.getDriver().getCab().setIsAvailable(true);
		tripBookingRepository2.save(tripBooking);

	}
}
