package model;

public class CabDriver {
	private String name;
	private char sex;
	private int age;
	private Car car;
	private Location driverLocation;
	public boolean availablilityStatus;
	public long totalEarning;

	public CabDriver() {
		this.availablilityStatus = true;
		this.totalEarning = 0;
	}

	public void add_driverDetails(String name, char sex, int age, String carName, String carNumber,
			Location driverLocation) {
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
		this.setCar(carName, carNumber);
		this.update_driverLocation(driverLocation);
	}

	public void display_driver() {
		System.out.println("DRIVER - " + "Name:" + this.name + " Sex:" + this.sex + " Age:" + this.age);
		car.display_car();
		driverLocation.display_Location();
		System.out.println();
	}

	public void update_driverLocation(Location location) {
		this.driverLocation = location;
	}

	public void update_driverStatus(boolean status) {
		this.availablilityStatus = status;
	}

	public boolean isAvailablilityStatus() {
		if (availablilityStatus)
			return true;
		return false;
	}

	public void add_earning(long earning) {
		totalEarning += earning;
	}

	public void display_earning() {
		System.out.println(name + " : " + "Rs." + totalEarning);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(String carName, String carNumber) {
		this.car = new Car(carName, carNumber);
	}

	public Location getDriverLocation() {
		return driverLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
