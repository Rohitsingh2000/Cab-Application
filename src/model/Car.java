package model;

public class Car {
	public String carName;
	public String carNumber;

	public Car(String carName, String carNumber) {
		this.carName = carName;
		this.carNumber = carNumber;
	}

	public void display_car() {
		System.out.println("CAR - " + "Model:" + this.carName + " CarNumber:" + this.carNumber);
	}
}
