package DAO;



import java.sql.*;
import java.util.*;
import Connection.ConnectionManager;
import Model.Driver;



public class DriverDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	private int driver_id,staff_id ;
	private String driver_name,driver_email,driver_icno,driver_phoneno,driver_address,driver_licenseno;
	

	//Complete getDriver() method(view)
	public static Driver getDriver(int driver_id) { 
		Driver d = new Driver();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();


			//create statement
			ps = con.prepareStatement("SELECT * FROM driver WHERE driver_id=?");
			ps.setInt(1, driver_id);
			
            //execute query
			rs = ps.executeQuery();
			if(rs.next()) {
			d.setDriver_id(rs.getInt("driver_id"));
			//d.setStaff_id(rs.getInt("staff_id"));
			d.setDriver_name(rs.getString("driver_name"));
			d.setDriver_email(rs.getString("driver_email"));
			d.setDriver_icno(rs.getString("driver_icno"));
			d.setDriver_phoneno(rs.getString("driver_phoneno"));
			d.setDriver_address(rs.getString("driver_address"));
			d.setDriver_licenseno(rs.getString("driver_licenseno"));
			
			
						
			}
			
            //close connection
			con.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d; 
	}

	//Complete addDriver() method
	public void addDriver(Driver bean) {
		
		//get values
		driver_id = bean.getDriver_id();
	    driver_name = bean.getDriver_name();
	    driver_email = bean.getDriver_email();
	    driver_icno = bean.getDriver_icno();
	    driver_phoneno = bean.getDriver_phoneno();
	    driver_address = bean.getDriver_address();
	    driver_licenseno= bean.getDriver_licenseno();
		staff_id = bean.getStaff_id();
		

		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
            //create statement
			ps = con.prepareStatement("INSERT INTO driver(driver_name,driver_email,driver_icno,driver_phoneno,driver_address,driver_licenseno)VALUES(?,?,?,?,?,?)");
		
			ps.setString(1, driver_name);
			ps.setString(2, driver_email);
			ps.setString(3, driver_icno);
			ps.setString(4, driver_phoneno);
			ps.setString(5, driver_address);
			ps.setString(6, driver_licenseno );
			//ps.setInt(7,staff_id);
			
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
           //close connection
			con.close();

		
          }catch(Exception e) {
			e.printStackTrace();				
		}
	}	

	//Complete deleteDriver() method
	public void deleteDriver(int driver_id) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

           //create statement
			ps = con.prepareStatement("DELETE FROM driver WHERE driver_id=?");
			ps.setInt(1, driver_id);

           //execute query
			ps.executeUpdate();
			
           //close connection
			con.close();


           }catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Complete update driver method
     public void updateDriver(Driver bean) {
    	driver_id=bean.getDriver_id();
    	driver_name = bean.getDriver_name();
 	    driver_email = bean.getDriver_email();
 	    driver_icno = bean.getDriver_icno();
 	    driver_phoneno = bean.getDriver_phoneno();
 	    driver_address = bean.getDriver_address();
 	    driver_licenseno= bean.getDriver_licenseno();
 		//staff_id = bean.getStaff_id();
		
		
		
		try {			
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement
			ps = con.prepareStatement("UPDATE driver SET driver_email=?, driver_phoneno=?,driver_address=? WHERE driver_id=?");
			
			ps.setString(1, driver_email);
			ps.setString(2, driver_phoneno);
			ps.setString(3, driver_address);
			ps.setInt(4, driver_id);
			
			//4. execute query
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}	


	//Complete getDriver() method(list)
	public static List<Driver> getDrivers() { 
		List<Driver> drivers = new ArrayList<Driver>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

            //create statement
			stmt = con.createStatement();
			String sql = "SELECT * FROM driver ORDER BY driver_id";

		 //execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Driver d = new Driver();
				d.setDriver_id(rs.getInt("driver_id"));
				//d.setStaff_id(rs.getInt("staff_id"));
				d.setDriver_name(rs.getString("driver_name"));
				d.setDriver_email(rs.getString("driver_email"));
				d.setDriver_icno(rs.getString("driver_icno"));
				d.setDriver_phoneno(rs.getString("driver_phoneno"));
				d.setDriver_address(rs.getString("driver_address"));
				d.setDriver_licenseno(rs.getString("driver_licenseno"));
				
				
				
				drivers.add(d);
			}
			
           //close connection
			con.close();
			

		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return drivers; 
	}

}
