package managers;

import dao.UserDao;
import entities.User;

public class UserManager {
	
	//we need to create an object instance because you cannot instantiate this class
	private static UserManager instance = new UserManager();
	
	private static UserDao dao = new UserDao();
	//by using a private constructor it means that the class cannot be instantiated
	private UserManager() {}

	//we need to create only one object(singleton pattern)
	//sense one cannot create an instance of a UserManager then it needs to be a static method(think utility)
	public static UserManager getInstance() {
		return instance;
		
	}
	
	public User createUser(long id, String email, String password, String firstName, String lastName, int gender, String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
	
		return user;
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}
}
