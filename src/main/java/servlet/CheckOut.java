package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DBconnection;
import dao.OrderDao;
import model.Cart;
import model.ModelOrder;
import model.User;
@WebServlet("/cart-check-out")
public class CheckOut extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			try(PrintWriter out = resp.getWriter()){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = new Date();
				ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart-list");
				User auth = (User) req.getSession().getAttribute("auth");
				if(cart_list != null && auth!=null) {
					for(Cart c:cart_list) {
						ModelOrder order = new ModelOrder();
						order.setId(c.getId());
						order.setUid(auth.getId());
						order.setQuantity(c.getQuantity());
						order.setDate(formatter.format(date));
						
						OrderDao oDao = new OrderDao(DBconnection.getConnection());
						boolean result = oDao.insertOrder(order);
						if(!result) break;
					}
					cart_list.clear();
					resp.sendRedirect("orders.jsp");
				}else {
					if(auth==null) {
						resp.sendRedirect("login.jsp");
					}
					resp.sendRedirect("cart.jsp");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
}

