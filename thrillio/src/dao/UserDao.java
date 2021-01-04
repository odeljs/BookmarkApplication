package dao;

import entities.User;
import thrillio.DataStore;
// A dao is used to mimic the SQl queries between the database and the application
public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
