package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/log-out")
public class LogOut extends HttpServlet{

	@Override
	
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		resp.setHeader("Expires", "0"); // Proxies.
		try {
	        if (req.getSession().getAttribute("auth") != null) {
	            req.getSession().invalidate(); // Invalidate the session
	        }
	        resp.sendRedirect("login.jsp");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		}

}
