package imaxct.test;

import java.util.List;

import imaxct.dao.UserDao;
import imaxct.model.User;

public class Test {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = userDao.find(User.class, "select * from User where username=?", "admin");
		System.out.println(user);
		
		
		
		List<User>list = userDao.list(User.class, "select * from User");
		if (list != null && !list.isEmpty())
			for (User u : list)
				System.out.println(u);
	}

}
