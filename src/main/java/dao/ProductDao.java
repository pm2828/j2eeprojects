package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Product;
public class ProductDao {
private Connection con;
	
	private static ResultSet rs;
	
	private PreparedStatement pstmt;
	
	private String query;

	public ProductDao(Connection con) {
		super();
		this.con = con;
	}

	
	public List<Product> getAllProducts(){
		
		List<Product> products=new ArrayList<Product>();
		
		query="select * from products";
		
		
		try {
			pstmt=this.con.prepareStatement(query);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Product row=new Product(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getDouble(4), rs.getString(5));
				
				products.add(row);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
		
	}
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pstmt = this.con.prepareStatement(query);
                    pstmt.setInt(1, item.getId());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select * from products where id=?";
                    pstmt = this.con.prepareStatement(query);
                    pstmt.setInt(1, item.getId());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setName(rs.getString("name"));
                        row.setCategory(rs.getString("category"));
                        row.setPrice(rs.getDouble("price")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }


	


	 public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            query = "select * from products where id=? ";

	            pstmt = this.con.prepareStatement(query);
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
}
