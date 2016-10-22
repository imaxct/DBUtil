package imaxct.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imaxct.dao.UserDao;
import imaxct.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("none");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String u = request.getParameter("u");
		String p = request.getParameter("p");
		UserDao userDao = new UserDao();
		User user = userDao.find(u, p);
		if (user != null)
			response.getWriter().println(user);
		else 
			response.getWriter().println("failed");
	}
}
