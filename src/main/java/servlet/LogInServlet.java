package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DBconnection;
import dao.UserDao;
import model.User;
@WebServlet("/user-login")
public class LogInServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.jsp");
		
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	resp.setHeader("Expires", "0"); // Proxies.
	
	resp.setContentType("text/html;charset=UTF-8");
	try(PrintWriter out=resp.getWriter()) {
		
		String email=req.getParameter("login-email");
		String password=req.getParameter("login-password");
		UserDao userdao=new UserDao(DBconnection.getConnection());
		User user=userdao.userLogin(email, password);

		if(user != null) {
			
			req.getSession().setAttribute("auth", user);
			resp.sendRedirect("index.jsp");
		}else {
			req.setAttribute("status", "failed");
			RequestDispatcher rd =req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
