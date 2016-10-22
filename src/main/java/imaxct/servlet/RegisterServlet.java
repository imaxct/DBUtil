package imaxct.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imaxct.dao.UserDao;
import imaxct.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("none");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String u = request.getParameter("u");
		String p = request.getParameter("p");
		if (u != null && !"".equals(u) && p != null && !"".equals(p)){
			User user = new User();
			user.setPassword(p);
			user.setUsername(u);
			UserDao userDao = new UserDao();
			if (userDao.saveUser(user))
				response.getWriter().println("success");
			else
				response.getWriter().println("fail");
		}else
			response.getWriter().println("error");
	}

}
