package model;

public class Location {
	private int x;
	private int y;

	// initialize the x and y coordinates of location
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void print_coordinates() {
		System.out.println(" (" + x + "," + y + ") ");
	}

	// return the distance between the two location
	public static long calculate_distance(Location source, Location destination) {
		int dx = destination.x - source.x;
		int dy = destination.y - source.y;
		long distance = Math.round(Math.sqrt(dx * dx + dy * dy));
		return distance;
	}

	public void display_Location() {
		System.out.println("LOCATION: " + "(" + x + "," + y + ")");
	}
}
