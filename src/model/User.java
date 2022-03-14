package model;

public class User {
	private String name;
	private char sex;
	private int age;
	private String phoneNumber;
	private Location userLocation;

	public void add_userDetails(String name, char sex, int age) {
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
	}

	public void display_user() {
		System.out.println(
				"Name:" + this.name + " Sex:" + this.sex + " Age:" + this.age);
		userLocation.display_Location();
		System.out.println();
	}

	public void update_user(String phoneNumber) {
		this.setPhoneNumber(phoneNumber);
	}

	public void update_userLocation(Location location) {
		this.userLocation = location;
	}

	public Location getUserLocation() {
		return userLocation;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
