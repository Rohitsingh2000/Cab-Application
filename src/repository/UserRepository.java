package repository;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserRepository {
	private List<User> userList;

	public UserRepository() {
		this.userList = new ArrayList<>();
	}

	public void display_userList() {
		if (!isEmptyList()) {
			int index = 1;
			System.out.println("LIST OF USERS");
			for (User u : userList) {
				System.out.println(index);
				u.display_user();
				index++;
			}
		}
	}

	public boolean isEmptyList() {
		return userList.isEmpty();
	}
	
	public void add_user(User u) {
		this.userList.add(u);

	}
}
