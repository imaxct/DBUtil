package imaxct.dao;

import imaxct.model.User;

public class UserDao extends BaseDao<User>{
	
	public boolean saveUser(User user) {
		if (user == null)
			return false;
		return this.update("insert into User (username, password) values (?, ?)", user.getUsername(), user.getPassword()) > 0;
	}
	
	public User find(String username, String password) {
		return this.find(User.class, "select * from User where username=? and password=?", username, password);
	}
}
