package model;

import java.util.ArrayList;
import java.util.List;

import repository.CabDriverRepository;

public class Ride {
	private User user;
	private CabDriver driver;
	private long cost_of_ride;
	private Location source;
	private Location destination;
	private List<CabDriver> driversAvailable;

	public Ride(User user, Location destination) {
		this.user = user;
		this.source = user.getUserLocation();
		this.destination = destination;
		this.driversAvailable = new ArrayList<>();
	}

	public List<CabDriver> find_ride() {
		System.out.println("FIND A RIDE ");
		System.out.print("UserName : " + user.getName() + " --- destination :");
		destination.print_coordinates();
		for (CabDriver driver : CabDriverRepository.getDriverList()) {
			// considering the driver only if he is available
			if (driver.availablilityStatus)
				// considering the driver only if the distance between user location and driver
				// location is not more then 5 units
				if (Location.calculate_distance(source, driver.getDriverLocation()) <= 5) {
					driversAvailable.add(driver);
				}
		}
		return driversAvailable;
	}

	public void choose_ride(int user_choice) {
		int list_index = user_choice - 1;
		// booking ride for user with the chosen driver
		this.driver = driversAvailable.get(list_index);
		System.out.println("Your ride is booked with " + driver.getName());

		// setting below value to make the driver unavailable for concurrent rides
		driver.update_driverStatus(false);

		System.out.println("Ride started !");
		System.out.println("*.....................*");
		System.out.println("Reached destination !");

	}

	public void calculate_ride() {
		// cost of ride is based on distance between source and destination of the ride
		cost_of_ride = Location.calculate_distance(source, destination);
		System.out.println("Cost of ride : Rs." + cost_of_ride);
		driver.add_earning(cost_of_ride);

		//update driver and user location after ride
		driver.update_driverLocation(destination);
		user.update_userLocation(destination);
		//update driver status to available after ride
		driver.update_driverStatus(true);
	}
}
