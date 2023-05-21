package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDao {
	
	private Connection con;
	
	private ResultSet rs;
	
	private PreparedStatement pstmt;
	
	private String query;

	public UserDao(Connection con) {
	
		this.con = con;
	}
	
	public User userLogin(String email,String password) {
		User user=null;
		
		try {
			query="select * from users where email=? and password=?";
			pstmt=this.con.prepareStatement(query);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
           rs= pstmt.executeQuery()   ;		
           
           if(rs.next()) {
        	   user=new User();
        	   user.setId(rs.getInt("id"));
        	   user.setName(rs.getString("name"));
        	   user.setEmail(rs.getString("email"));
        	   
           }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

}
