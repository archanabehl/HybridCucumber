package Utilities;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mongodb.connection.Connection;

import BaseClass.Library;

public class DBConnectivity extends Library {
	

		public User getCredentialsFromDB() {//throws ClassNotFoundException,SQLException {
			{
				String dburl =properties.getProperty("dburl");//testing is the DB name 
				// String username ="root";//username of db
				//String password ="geetu123";//pwd of db
				String username =properties.getProperty("dbusername");
				String password =properties.getProperty("dbpassword");
				//String query ="Select * from login where email='abc@gmail.com'";//login table from db
				String query = properties.getProperty("dbquery");
				java.sql.Connection con= null;
				ResultSet rs = null;
				Statement stmt = null;
				User user = new User();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); 
					con = DriverManager.getConnection(dburl, username, password);
					stmt = con.createStatement();
					rs = stmt.executeQuery(query);

					while(rs.next()) {

						user.setUserName(rs.getString("username"));
						user.setPassword(rs.getString("password"));

					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						stmt.close();
						con.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}

				return user;		

			}

		}
}
