package servlet;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DBconnection;
import dao.OrderDao;
import model.User;

@WebServlet("/cancel-order")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(PrintWriter out = resp.getWriter()) {
			String id = req.getParameter("id");
			
			User auth = (User) req.getSession().getAttribute("auth");
			if(id != null && auth!=null) {
				OrderDao orderDao = new OrderDao(DBconnection.getConnection());
				orderDao.cancelOrder(Integer.parseInt(id));
			}
			resp.sendRedirect("orders.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}


