package Driver;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.CabDriver;
import model.Location;
import model.Ride;
import model.User;
import repository.CabDriverRepository;
import repository.UserRepository;

public class Driver {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		UserRepository ur = new UserRepository();
		CabDriverRepository driverRepo = new CabDriverRepository();

		/* add user 1 */
		User user1 = new User();
		user1.add_userDetails("Abhishek", 'M', 47);
		Location user1Location = new Location(0, 0);
		user1.update_userLocation(user1Location);
		user1.update_user("9245132541");
		ur.add_user(user1);

		/* add user 2 */
		User user2 = new User();
		user2.add_userDetails("Rahul", 'M', 50);
		Location user2Location = new Location(10, 0);
		user2.update_userLocation(user2Location);
		ur.add_user(user2);

		/* add user 3 */
		User user3 = new User();
		user3.add_userDetails("Nandini", 'F', 37);
		Location user3Location = new Location(15, 6);
		user3.update_userLocation(user3Location);
		ur.add_user(user3);

		/* add driver 1 */
		CabDriver cd1 = new CabDriver();
		Location cd1Location = new Location(10, 1);
		cd1.add_driverDetails("Driver1", 'M', 25, "Swift", "DL11BK5999", cd1Location);
		driverRepo.add_driver(cd1);

		/* add driver 2 */
		CabDriver cd2 = new CabDriver();
		Location cd2Location = new Location(11, 10);
		cd2.add_driverDetails("Driver2", 'M', 30, "Seltos", "DL44BL5427", cd2Location);
		driverRepo.add_driver(cd2);

		/* add driver 3 */
		CabDriver cd3 = new CabDriver();
		Location cd3Location = new Location(5, 3);
		cd3.add_driverDetails("Driver3", 'M', 29, "XUV500", "DL58AK2342", cd3Location);
		driverRepo.add_driver(cd3);

		/* user 1 searches for a ride */

		// set destination
		Location destination1 = new Location(20, 1);
		Ride r1 = new Ride(user1, destination1);
		// book a ride
		book_ride(r1);

		System.out.println();

		/* user 2 searches for a ride */
		Location destination2 = new Location(15, 3);
		Ride r2 = new Ride(user2, destination2);
		book_ride(r2);

		System.out.println();

		/* user 3 searches for a ride */
		Location destination3 = new Location(20, 4);
		Ride r3 = new Ride(user3, destination3);
		book_ride(r3);

		System.out.println();

		/* display earnings of all drivers */
		driverRepo.display_totalEarning();

		System.out.println();

		/* displays all users and their details */
		// ur.display_userList();

		System.out.println();

		/* displays all drivers and their details */
		// driverRepo.display_driverList();
		
		sc.close();

	}

	public static void book_ride(Ride ride) {
		int user_choice;
		// find available drivers
		List<CabDriver> cd = ride.find_ride();
		try {
			CabDriverRepository.display_driverList(cd);
			// user to choose from available drivers
			System.out.print("Select a driver from above list : ");
			user_choice = Integer.valueOf(sc.nextLine());
			ride.choose_ride(user_choice);
			// calculate cost for ride
			ride.calculate_ride();
		} catch (Exception e) {
			System.out.println("NO DRIVERS AVAILABLE AT THE MOMENT, TRY AFTER SOME TIME!");

		}
	}
}
