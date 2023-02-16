package DAO;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import Connection.ConnectionManager;
import Model.Vehicles;

public class VehiclesDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private int vec_id; 
	private String vec_plateno;
	private String vec_name;
	private Date vec_rtdate;
	private int driver_id;
	private int staff_id;

	//Complete getVehicle() method
	public static Vehicles getVehicle(int vec_id) { 
		Vehicles vehicle = new Vehicles();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			ps = con.prepareStatement("SELECT * FROM vehicle WHERE vec_id=?");
			ps.setInt(1, vec_id);

			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				vehicle.setVec_id(rs.getInt("vec_id"));
				vehicle.setDriver_id(rs.getInt("driver_id"));
				vehicle.setStaff_id(rs.getInt("staff_id"));
				vehicle.setVec_plateno(rs.getString("vec_plateno"));
				vehicle.setVec_name(rs.getString("vec_name"));
				vehicle.setVec_rtdate(rs.getDate("vec_rtdate"));
			}
			
			//close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle; 
	}

	//Complete addVehicle() method
	public void addVehicle(Vehicles bean) {
		
		//get values
		vec_id = bean.getVec_id();
		vec_plateno = bean.getVec_plateno();
		vec_name= bean.getVec_name();
		vec_rtdate = bean.getVec_rtdate();
		driver_id= bean.getDriver_id();
		staff_id = bean.getStaff_id();
		
		java.sql.Date rtdate = new java.sql.Date(vec_rtdate.getTime());


		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			ps = con.prepareStatement("INSERT INTO vehicle(vec_plateno,vec_name,vec_rtdate)VALUES(?,?,?)");
			ps.setString(1, vec_plateno);
			ps.setString(2, vec_name);
			ps.setDate(3, rtdate);
			
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");

			//close connection
			con.close();
			

		}catch(Exception e) {
			e.printStackTrace();				
		}
	}	

	//Complete deleteVehicle() method
	public void deleteVehicle(int vec_id) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//create statement 
			ps = con.prepareStatement("DELETE FROM vehicle WHERE vec_id=?");
			ps.setInt(1, vec_id);

			//execute query
			ps.executeUpdate();

			//close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Complete getVehicles() method
	public static List<Vehicles> getVehicles() { 
		List<Vehicles> vehicles = new ArrayList<Vehicles>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM vehicle ORDER BY vec_id";

			//execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Vehicles vehicle = new Vehicles();
				vehicle.setVec_id(rs.getInt("vec_id"));	
				vehicle.setVec_plateno(rs.getString("vec_plateno"));
				vehicle.setVec_name(rs.getString("vec_name"));
				vehicle.setVec_rtdate(rs.getDate("vec_rtdate"));
				vehicles.add(vehicle);
			}

			//close connection
			con.close();

		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return vehicles; 
	}
	
	//update 
	
		public void updateVehicle(Vehicles bean) {
			
			vec_id = bean.getVec_id();
			vec_rtdate = bean.getVec_rtdate();
			
			java.sql.Date rtdate = new java.sql.Date(vec_rtdate.getTime());
			
			try {			
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//3. create statement
				ps = con.prepareStatement("UPDATE vehicle SET vec_rtdate=? WHERE vec_id=?");
				ps.setDate(1, rtdate);
				ps.setInt(2, vec_id);
				
				//4. execute query
				ps.executeUpdate();
				
				System.out.println("Successfully updated");
				
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}

}
