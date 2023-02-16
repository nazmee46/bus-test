package DAO;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import Connection.ConnectionManager;
import Model.Bookings;

public class BookingsDAO {
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private int book_id;
	private String book_name;
	private String book_phoneno;
	Date book_date;
	Time book_time;
	private String book_route;
	private int book_seat;
	private double book_price;
	private int vec_id;
	
	//Complete getCustomerBooking() method
		public static Bookings getCustomerBooking(int book_id) { 
			Bookings booking = new Bookings();
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();

				//create statement
				ps = con.prepareStatement("SELECT * FROM booking WHERE book_id=?");
				ps.setInt(1, book_id);

				//execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					booking.setBook_id(rs.getInt("book_id"));
					booking.setBook_name(rs.getString("book_name"));
					booking.setBook_phoneno(rs.getString("book_phoneno"));
					booking.setBook_date(rs.getDate("book_date"));
					booking.setBook_route(rs.getString("book_route"));
					booking.setBook_seat(rs.getInt("book_seat"));
					booking.setBook_price(rs.getFloat("book_price"));
					booking.setVec_id(rs.getInt("vec_id"));
				}
				
				//close connection
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return booking; 
		}

		//Complete addBooking() method
		public void addBooking(Bookings bean) {
			
			//get values
			book_id = bean.getBook_id();
			book_name = bean.getBook_name();
			book_phoneno = bean.getBook_phoneno();
			book_date = bean.getBook_date();
			book_time = bean.getBook_time();
			book_route = bean.getBook_route();
			book_seat = bean.getBook_seat();
			book_price = bean.getBook_price();
			vec_id = bean.getVec_id();
			
			java.sql.Date bdate = new java.sql.Date(book_date.getTime());

			try {			
				//call getConnection() method
				con = ConnectionManager.getConnection();

				//create statement
				//ps = con.prepareStatement("INSERT INTO booking(book_name,book_phoneno,book_date,book_time,book_route,book_seat,book_price,vec_id)VALUES(?,?,?,?,?,?,?,?)");
				ps = con.prepareStatement("INSERT INTO booking(book_name,book_phoneno,book_date,book_route,book_seat)VALUES(?,?,?,?,?)");
				//ps = con.prepareStatement("INSERT INTO booking(book_date,book_route,book_seat)VALUES(?,?,?)");
				ps.setString(1, book_name);
				ps.setString(2, book_phoneno);
				ps.setDate(3, bdate);
				//ps.setFloat(4, book_time);
				ps.setString(4, book_route);
				ps.setInt(5, book_seat);
				//ps.setDouble(6, book_price);
				//ps.setInt(8, vec_id);
				
				
				//execute query
				ps.executeUpdate();
				System.out.println("Successfully inserted");

				//close connection
				con.close();
				

			}catch(Exception e) {
				e.printStackTrace();				
			}
		}	


		//Complete getCustomerBookings() method
		public static List<Bookings> getCustomerBookings() { 
			List<Bookings> bookings = new ArrayList<Bookings>(); 
			try { 
				//call getConnection() method
				con = ConnectionManager.getConnection();

				//create statement
				stmt = con.createStatement();
				String sql = "SELECT * FROM booking ORDER BY book_id";

				//execute query
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Bookings booking = new Bookings();
					booking.setBook_name(rs.getString("book_name"));
					booking.setBook_phoneno(rs.getString("book_phoneno"));
					booking.setBook_date(rs.getDate("book_date"));
					booking.setBook_route(rs.getString("book_route"));
					booking.setBook_seat(rs.getInt("book_seat"));
					booking.setVec_id(rs.getInt("vec_id"));
					bookings.add(booking);
				}

				//close connection
				con.close();

			} catch (Exception e) { 
				e.printStackTrace(); 
			}

			return bookings; 
		}

}
