package repository;

import java.util.ArrayList;
import java.util.List;

import model.CabDriver;

public class CabDriverRepository {
	private static List<CabDriver> driverList;

	public CabDriverRepository() {
		driverList = new ArrayList<>();
	}

	public void add_driver(CabDriver cd) {
		driverList.add(cd);
	}

	public static void display_driverList(List<CabDriver> driverList) throws Exception {
		if (isEmptyList(driverList)) {
			throw new Exception("no drivers available");
		}

		int index = 1;
		System.out.println("\n"+"LIST OF DRIVERS ");
		for (CabDriver cd : driverList) {
			System.out.println(index);
			cd.display_driver();
			index++;
		}

	}

	public void display_driverList() {
		int index = 1;
		System.out.println("\n"+"LIST OF DRIVERS ");
		for (CabDriver cd : driverList) {
			System.out.println(index);
			cd.display_driver();
			index++;
		}
	}

	
	public void display_totalEarning() {
		if (!isEmptyList(driverList)) {
			System.out.println("TOTAL EARNING OF EACH DRIVER");
			for (CabDriver cd : driverList) {
				cd.display_earning();
			}
		}
	}

	public static boolean isEmptyList(List<CabDriver> driverList) {
		return driverList.isEmpty();
	}

	public CabDriver get_driver(int list_index) {
		return driverList.get(list_index);
	}

	public static List<CabDriver> getDriverList() {
		return driverList;
	}

}
